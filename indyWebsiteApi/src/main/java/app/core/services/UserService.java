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
import app.core.sessions.Session;
import app.core.sessions.SessionContext;

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
	
	public List<Purchase> getOrders(String token) throws ApiException{
		Session session = sessionContext.getSession(token);
		if (session == null)
			throw new ApiException("User Not Fount !!! ");
		int id = (int) session.getAttribute("userId");
		return purchaseRepository.findByUserId(id);
	}
	
	public List<PurchaseEntry> getOrdersDetails(String token) throws ApiException{
		List<Purchase> orderList = getOrders(token);
		List<PurchaseEntry> detailsList = new ArrayList<>();
		for ( Purchase currentOrder : orderList ) {
			detailsList.addAll(purchaseEntryRepository.findByPurchaseId(currentOrder.getId()));
		}
		return detailsList;
	}
	
	public User updateDetails(String token, User user) throws ApiException{
		Session session = sessionContext.getSession(token);
		if (session == null)
			throw new ApiException("User Not Fount !!! ");
		Optional<User> opt = userRepository.findById((int)session.getAttribute("userId"));
		if(opt.isEmpty()) {
			throw new ApiException("User Not Fount !!! ");
		}
		User newUser = opt.get();
		newUser.setAddress(user.getAddress());
		newUser.setPhone(user.getPhone());
		newUser.setUsername(user.getUsername());
		return newUser;
	}
	public User changeEmail(String token, User user) throws ApiException{
		Session session = sessionContext.getSession(token);
		if (session == null)
			throw new ApiException("User Not Fount !!! ");
		Optional<User> opt = userRepository.findById((int)session.getAttribute("userId"));
		if(opt.isEmpty()) {
			throw new ApiException("User Not Fount !!! ");
		}
		User newUser = opt.get();
		newUser.setEmail(user.getEmail());
		return newUser;
	}
	
	

}
