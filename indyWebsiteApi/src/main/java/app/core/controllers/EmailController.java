package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.apiException.ApiException;
import app.core.services.EmailService;
import app.core.util.EmailForm;

@RestController
@RequestMapping("/user/email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {
	@Autowired
	EmailService emailService;
	
	@PostMapping("/sendEmailShipped")
	public void sendEmailReceipt(@RequestHeader String token,  @ModelAttribute EmailForm emailForm  ) {
		try {
			emailService.sendSimpleMessage(emailForm.getEmail(), emailForm.getSubject(), emailForm.getBody());
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@PostMapping("/sendEmailReceipt")
	public void sendEmailShipped(@RequestHeader String token,  @ModelAttribute EmailForm emailForm ) {
		try {
			emailService.sendMessageWithAttachment(emailForm.getEmail(), emailForm.getSubject(), emailForm.getBody(),emailForm.getAttachment());
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	
	
}
