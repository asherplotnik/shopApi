package app.core.services;

import java.io.File;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.core.apiException.ApiException;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) throws ApiException {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("noreply@indyfashion.com");
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);
			emailSender.send(message);
			System.out.println("shipped email sent to " + to );
		} catch (Exception e) {
			throw new ApiException("Send shipped-email failed !!!");
		}
	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, MultipartFile attachmentFile)
			throws ApiException {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("noreply@indyfashion.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			String destDir = "src/main/resources/attachment";
			File dir = new File(destDir);
			if (!dir.exists())
				dir.mkdirs();
			File newFile = new File(
					"C:\\Users\\ASHER\\git\\indyWebsiteApi\\indyWebsiteApi\\src\\main\\resources\\attachment\\attachment.pdf");
			attachmentFile.transferTo(newFile);
			FileSystemResource file = new FileSystemResource(newFile);
			helper.addAttachment("Receipt.pdf", file);
			emailSender.send(message);
			File[] files = dir.listFiles();
			if (files != null) {
				for (File f : files) {
					f.delete();
				}
			}
			dir.delete();
			System.out.println("confirmed email sent to " + to );
		} catch (MessagingException e) {
			throw new ApiException("Send confirmed-email failed !!!");
		} catch (IllegalStateException e) {
			throw new ApiException("Send confirmed-email failed !!!");
		} catch (IOException e) {
			throw new ApiException("Send confirmed-email failed !!!");
		}
	}
	
	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, File attachmentFile)
			throws ApiException {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("noreply@indyfashion.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			String destDir = "src/main/resources/attachment";
			File dir = new File(destDir);
			if (!dir.exists())
				dir.mkdirs();
			FileSystemResource file = new FileSystemResource(attachmentFile);
			helper.addAttachment("Receipt.pdf", file);
			emailSender.send(message);
			File[] files = dir.listFiles();
			if (files != null) {
				for (File f : files) {
					f.delete();
				}
			}
			dir.delete();
			System.out.println("confirmed email sent to " + to );
		} catch (MessagingException e) {
			throw new ApiException("Send confirmed-email failed !!!");
		} catch (IllegalStateException e) {
			throw new ApiException("Send confirmed-email failed !!!");
		} 
	}
}