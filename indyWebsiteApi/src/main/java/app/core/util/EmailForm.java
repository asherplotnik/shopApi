package app.core.util;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class EmailForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
    private String subject;
    private String body;
    private MultipartFile attachment;
    
    public EmailForm() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public MultipartFile getAttachment() {
		return attachment;
	}

	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}

	

	

}
