package app.core.util;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class PayLoad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String mainTitle;
    private String mainTitleT;
    private String firstParagraph;
    private String secondParagraph;
    private String thirdParagraph;
    private String firstParagraphT;
    private String secondParagraphT;
    private String thirdParagraphT;
    private MultipartFile firstImage;
    private MultipartFile secondImage;
    private MultipartFile thirdImage;
    
    public PayLoad() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}

	public String getMainTitleT() {
		return mainTitleT;
	}

	public void setMainTitleT(String mainTitleT) {
		this.mainTitleT = mainTitleT;
	}

	public String getFirstParagraph() {
		return firstParagraph;
	}

	public void setFirstParagraph(String firstParagraph) {
		this.firstParagraph = firstParagraph;
	}

	public String getSecondParagraph() {
		return secondParagraph;
	}

	public void setSecondParagraph(String secondParagraph) {
		this.secondParagraph = secondParagraph;
	}

	public String getThirdParagraph() {
		return thirdParagraph;
	}

	public void setThirdParagraph(String thirdParagraph) {
		this.thirdParagraph = thirdParagraph;
	}

	public String getFirstParagraphT() {
		return firstParagraphT;
	}

	public void setFirstParagraphT(String firstParagraphT) {
		this.firstParagraphT = firstParagraphT;
	}

	public String getSecondParagraphT() {
		return secondParagraphT;
	}

	public void setSecondParagraphT(String secondParagraphT) {
		this.secondParagraphT = secondParagraphT;
	}

	public String getThirdParagraphT() {
		return thirdParagraphT;
	}

	public void setThirdParagraphT(String thirdParagraphT) {
		this.thirdParagraphT = thirdParagraphT;
	}

	public MultipartFile getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(MultipartFile firstImage) {
		this.firstImage = firstImage;
	}

	public MultipartFile getSecondImage() {
		return secondImage;
	}

	public void setSecondImage(MultipartFile secondImage) {
		this.secondImage = secondImage;
	}

	public MultipartFile getThirdImage() {
		return thirdImage;
	}

	public void setThirdImage(MultipartFile thirdImage) {
		this.thirdImage = thirdImage;
	}
    
    

	

}
