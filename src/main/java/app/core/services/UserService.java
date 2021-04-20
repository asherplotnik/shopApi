package app.core.services;

import java.io.File;
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
import app.core.util.CheckoutPayload;
import app.core.util.FirstPdf;
import app.core.util.SignInDetails;
import app.core.util.TransactionForm;

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
	@Autowired
	private AdminService adminService;
	@Autowired
	private EmailService emailService;
	
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
			User newUser = getUserWithToken(token);
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
			User newUser = getUserWithToken(token);
			newUser.setEmail(user.getEmail());
			return newUser;
		} catch (Exception e) {
			throw new ApiException(" change email Failed !!!");
		}
	}

	public boolean changePassword(String token, SignInDetails payload) throws ApiException {
		try {
			User newUser = getUserWithToken(token);
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

	public Purchase saveOrder(String token, CheckoutPayload payload) throws ApiException {
		try {
			User user = getUserWithToken(token);
			Purchase purchase = payload.purchase;
			List<PurchaseEntry> entries = payload.entries; 
			purchase.setUser(user);
			for(int i=0;i< entries.size();i++) {
				purchase.addEntry(entries.get(i));
			}
			Purchase updated = purchaseRepository.save(purchase);
			if (updated != null) {
				for (PurchaseEntry entry: purchase.getEntries()) {
				TransactionForm tf = new TransactionForm();
					tf.setCode(entry.getCode());
					tf.setInorout(false);
					tf.setVariation(entry.getVariation());
					tf.setNote("ordered: "+purchase.getUser().getUsername());
					tf.setQty(entry.getQuantity());
					tf.setOrderid(purchase.getId());
					adminService.addTransaction(tf);
				}
				FirstPdf.createPdfFile(updated);
				String subject = "Indy fasion - confirmation";
				String body = "Dear Customer. \n We have received your order and we are proccesing your payment. \n"
						+ "We will soon send you confirmation of the payment.\n"
						+"please see attached confirmation of your order.";
				 String path = new File("src/main/resources/confirm.pdf").getAbsolutePath();    
				File newFile = new File(path);
				emailService.sendMessageWithAttachment(purchase.getUser().getEmail(), subject, body, newFile);
				return updated;
			} else {
				throw new ApiException(" save order Failed !!!");
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new ApiException(" save order Failed !!!");
		}
	}

	public User getUserWithToken(String token) throws ApiException {
		try {
			Session session = sessionContext.getSession(token);
			if (session == null)
				throw new ApiException("User Not Fount !!! ");
			Optional<User> opt = userRepository.findById((int) session.getAttribute("userId"));
			if (opt.isEmpty()) {
				throw new ApiException("User Not Fount !!! ");
			}
			return opt.get();
		} catch (Exception e) {
			throw new ApiException(" get user Failed !!!");
		}
	}

}
