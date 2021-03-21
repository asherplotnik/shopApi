package app.core.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.core.apiException.ApiException;
import app.core.entities.User;
import app.core.repositories.UserRepository;
import app.core.securirty.PasswordUtils;
import app.core.sessions.Session;
import app.core.sessions.SessionContext;

@Service
@Transactional
public class LoginService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SessionContext context;
	
	
	public LoginService() {
	}
	
	public boolean isEmailExists(String email) {
		User user = userRepository.findByEmail(email);
		if (user!=null)
			return user.getEmail().equals(email);
		else 
			return false;
	}
	
	public User signUp(User userDetails) throws ApiException{
		if (isEmailExists(userDetails.getEmail())) {
			throw new ApiException("Email exists already!");
		}
		String receivedPassword = userDetails.getPassword();
		String salt = PasswordUtils.getSalt(30);
		String securePassword = PasswordUtils.generateSecurePassword(receivedPassword, salt);
		userDetails.setPassword(securePassword);
		userDetails.setSalt(salt);
		userRepository.save(userDetails);
		return userDetails;
	}
	
	public Session signIn(String email, String password) throws ApiException{
		User user = userRepository.findByEmail(email);
		String securePassword = user.getPassword();
		String salt = user.getSalt();
		boolean passwordMatch = PasswordUtils.verifyUserPassword(password, securePassword, salt);
		if (passwordMatch) {
			Session session = context.createSession(user.getEmail());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("address", user.getAddress());
			session.setAttribute("phone", user.getPhone());
			session.setAttribute("level", user.getLevel());
			session.setAttribute("userId", user.getId());
			session.setAttribute("expiration", session.getLastAccessed());
			session.setAttribute("token", session.token);
			return session;
		} else {
			throw new ApiException("Login failed!");
		}
	}
	
	public void signOut (String token) {
		Session session = context.getSession(token);
		context.invalidate(session);
	}
}
