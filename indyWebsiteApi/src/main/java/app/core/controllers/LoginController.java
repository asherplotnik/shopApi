package app.core.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import app.core.apiException.ApiException;
import app.core.entities.User;
import app.core.services.LoginService;
import app.core.sessions.Session;
import app.core.util.SignInDetails;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/signUp")
	public User signUp(@RequestBody User userDetails) {
		try {
			return loginService.signUp(userDetails);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,e.getLocalizedMessage());
		}
	}
	
	@PostMapping("/signIn")
	public Map<String, Object> signIn(@RequestBody SignInDetails signInDetails) {
		try {
			Session session = loginService.signIn(signInDetails.email,signInDetails.password);
			return session.getAttributes();
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getLocalizedMessage());
		}
		
	}
	
	@PostMapping("/signOut")
	public String signOut(@RequestHeader String token) {
		loginService.signOut(token);
		return "Signed Out";
	}
	
}



