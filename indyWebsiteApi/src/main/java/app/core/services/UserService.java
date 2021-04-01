package app.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.apiException.ApiException;
import app.core.entities.Purchase;
import app.core.entities.PurchaseEntry;
import app.core.entities.User;
import app.core.repositories.PurchaseEntryRepository;
import app.core.repositories.PurchaseRepository;
import app.core.repositories.UserRepository;
import app.core.securirty.PasswordUtils;
import app.core.sessions.Session;
import app.core.sessions.SessionContext;
import app.core.util.SignInDetails;

@Service
@Transactional
public class UserService {
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private PurchaseEntryRepository purchaseEntryRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SessionContext sessionContext;

	public List<Purchase> getOrders(String token) throws ApiException {
		try {
			Session session = sessionContext.getSession(token);
			if (session == null)
				throw new ApiException("User Not Fount !!! ");
			int id = (int) session.getAttribute("userId");
			return purchaseRepository.findByUserId(id);
		} catch (Exception e) {
			throw new ApiException(" get orders Failed !!!");
		}
	}

	public List<PurchaseEntry> getOrdersDetails(String token) throws ApiException {
		try {
			List<Purchase> orderList = getOrders(token);
			List<PurchaseEntry> detailsList = new ArrayList<>();
			for (Purchase currentOrder : orderList) {
				detailsList.addAll(purchaseEntryRepository.findByPurchaseId(currentOrder.getId()));
			}
			return detailsList;
		} catch (Exception e) {
			throw new ApiException(" get ordersDetails Failed !!!");
		}
	}

	public User updateDetails(String token, User user) throws ApiException {
		try {
			Session session = sessionContext.getSession(token);
			if (session == null)
				throw new ApiException("User Not Fount !!! ");
			Optional<User> opt = userRepository.findById((int) session.getAttribute("userId"));
			if (opt.isEmpty()) {
				throw new ApiException("User Not Fount !!! ");
			}
			User newUser = opt.get();
			newUser.setAddress(user.getAddress());
			newUser.setPhone(user.getPhone());
			newUser.setUsername(user.getUsername());
			return newUser;
		} catch (Exception e) {
			throw new ApiException(" Update user Failed !!!");
		}
	}

	public User changeEmail(String token, User user) throws ApiException {
		try {
			Session session = sessionContext.getSession(token);
			if (session == null)
				throw new ApiException("User Not Fount !!! ");
			Optional<User> opt = userRepository.findById((int) session.getAttribute("userId"));
			if (opt.isEmpty()) {
				throw new ApiException("User Not Fount !!! ");
			}
			User newUser = opt.get();
			newUser.setEmail(user.getEmail());
			return newUser;
		} catch (Exception e) {
			throw new ApiException(" change email Failed !!!");
		}
	}

	public boolean changePassword(String token, SignInDetails payload) throws ApiException {
		try {
			Session session = sessionContext.getSession(token);
			if (session == null)
				throw new ApiException("User Not Fount !!! ");
			Optional<User> opt = userRepository.findById((int) session.getAttribute("userId"));
			if (opt.isEmpty()) {
				throw new ApiException("User Not Fount !!! ");
			}
			User newUser = opt.get();
			String salt = PasswordUtils.getSalt(30);
			String securePassword = PasswordUtils.generateSecurePassword(payload.password, salt);
			newUser.setPassword(securePassword);
			newUser.setSalt(salt);
			System.out.println("Password changed successfuly.");
			return true;
		} catch (Exception e) {
			throw new ApiException(" change password Failed !!!");
		}
	}

}
