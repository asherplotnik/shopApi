package app.core.services;

import org.springframework.web.multipart.MultipartFile;

import app.core.apiException.ApiException;

public interface EmailService {
	void sendSimpleMessage(String to, String subject, String text) throws ApiException ;
	
	void sendMessageWithAttachment(String to, String subject, String text, MultipartFile attachmentFile) throws ApiException ;
}
