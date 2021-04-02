package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.apiException.ApiException;
import app.core.entities.Purchase;
import app.core.entities.PurchaseEntry;
import app.core.entities.User;
import app.core.services.UserService;
import app.core.util.CheckoutPayload;
import app.core.util.SignInDetails;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/getOrders")
	public List<Purchase> getOrders(@RequestHeader String token){
		try {
			return userService.getOrders(token);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getLocalizedMessage());
		}
	}
	
	@GetMapping("/getOrdersDetails")
	public List<PurchaseEntry> getOrdersDetails(@RequestHeader String token){
		try {
			return userService.getOrdersDetails(token);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getLocalizedMessage());
		}
	}
	
	@PostMapping("/updateDetails")
	public User updateDetails(@RequestHeader String token,@ModelAttribute User user){
		try {
			return userService.updateDetails(token,user);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getLocalizedMessage());
		}
	}
	
	@PostMapping("/changeEmail")
	public User changeEmail(@RequestHeader String token,@ModelAttribute User user){
		try {
			return userService.changeEmail(token,user);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getLocalizedMessage());
		}
	}
	
	@PostMapping("/changePassword")
	public boolean changePassword(@RequestHeader String token,@RequestBody SignInDetails payload){
		try {
			return userService.changePassword(token,payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getLocalizedMessage());
		}
	}
	
	@PostMapping("/checkoutwire")
	public Purchase checkoutwire(@RequestHeader String token,@RequestBody CheckoutPayload payload) {
		try {
			return userService.saveOrder(token,payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getLocalizedMessage());
		}
	}
	
}
