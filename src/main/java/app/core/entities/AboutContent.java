package app.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class AboutContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String mainTitle;
    private String mainTitleT;
    @Lob 
    @Column(length=500)
    private String firstParagraph;
    @Lob 
    @Column(length=500)
    private String secondParagraph;
    @Lob 
    @Column(length=500)
    private String thirdParagraph;
    @Lob 
    @Column(length=500)
    private String firstParagraphT;
    @Lob 
    @Column(length=500)
    private String secondParagraphT;
    @Lob 
    @Column(length=500)
    private String thirdParagraphT;
    private String firstImage;
    private String secondImage;
    private String thirdImage;
    
    public AboutContent() {
	}
    public AboutContent(int id) {
    	this.id=id;
    }
    
    

	public AboutContent(String mainTitle, String mainTitleT, String firstParagraph, String secondParagraph,
			String thirdParagraph, String firstParagraphT, String secondParagraphT, String thirdParagraphT,
			String firstImage, String secondImage, String thirdImage) {
		this.mainTitle = mainTitle;
		this.mainTitleT = mainTitleT;
		this.firstParagraph = firstParagraph;
		this.secondParagraph = secondParagraph;
		this.thirdParagraph = thirdParagraph;
		this.firstParagraphT = firstParagraphT;
		this.secondParagraphT = secondParagraphT;
		this.thirdParagraphT = thirdParagraphT;
		this.firstImage = firstImage;
		this.secondImage = secondImage;
		this.thirdImage = thirdImage;
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



	public String getFirstImage() {
		return firstImage;
	}



	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}



	public String getSecondImage() {
		return secondImage;
	}



	public void setSecondImage(String secondImage) {
		this.secondImage = secondImage;
	}



	public String getThirdImage() {
		return thirdImage;
	}



	public void setThirdImage(String thirdImage) {
		this.thirdImage = thirdImage;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstImage == null) ? 0 : firstImage.hashCode());
		result = prime * result + ((firstParagraph == null) ? 0 : firstParagraph.hashCode());
		result = prime * result + ((firstParagraphT == null) ? 0 : firstParagraphT.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mainTitle == null) ? 0 : mainTitle.hashCode());
		result = prime * result + ((mainTitleT == null) ? 0 : mainTitleT.hashCode());
		result = prime * result + ((secondImage == null) ? 0 : secondImage.hashCode());
		result = prime * result + ((secondParagraph == null) ? 0 : secondParagraph.hashCode());
		result = prime * result + ((secondParagraphT == null) ? 0 : secondParagraphT.hashCode());
		result = prime * result + ((thirdImage == null) ? 0 : thirdImage.hashCode());
		result = prime * result + ((thirdParagraph == null) ? 0 : thirdParagraph.hashCode());
		result = prime * result + ((thirdParagraphT == null) ? 0 : thirdParagraphT.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AboutContent other = (AboutContent) obj;
		if (firstImage == null) {
			if (other.firstImage != null)
				return false;
		} else if (!firstImage.equals(other.firstImage))
			return false;
		if (firstParagraph == null) {
			if (other.firstParagraph != null)
				return false;
		} else if (!firstParagraph.equals(other.firstParagraph))
			return false;
		if (firstParagraphT == null) {
			if (other.firstParagraphT != null)
				return false;
		} else if (!firstParagraphT.equals(other.firstParagraphT))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mainTitle == null) {
			if (other.mainTitle != null)
				return false;
		} else if (!mainTitle.equals(other.mainTitle))
			return false;
		if (mainTitleT == null) {
			if (other.mainTitleT != null)
				return false;
		} else if (!mainTitleT.equals(other.mainTitleT))
			return false;
		if (secondImage == null) {
			if (other.secondImage != null)
				return false;
		} else if (!secondImage.equals(other.secondImage))
			return false;
		if (secondParagraph == null) {
			if (other.secondParagraph != null)
				return false;
		} else if (!secondParagraph.equals(other.secondParagraph))
			return false;
		if (secondParagraphT == null) {
			if (other.secondParagraphT != null)
				return false;
		} else if (!secondParagraphT.equals(other.secondParagraphT))
			return false;
		if (thirdImage == null) {
			if (other.thirdImage != null)
				return false;
		} else if (!thirdImage.equals(other.thirdImage))
			return false;
		if (thirdParagraph == null) {
			if (other.thirdParagraph != null)
				return false;
		} else if (!thirdParagraph.equals(other.thirdParagraph))
			return false;
		if (thirdParagraphT == null) {
			if (other.thirdParagraphT != null)
				return false;
		} else if (!thirdParagraphT.equals(other.thirdParagraphT))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "AboutContent [id=" + id + ", mainTitle=" + mainTitle + ", mainTitleT=" + mainTitleT
				+ ", firstParagraph=" + firstParagraph + ", secondParagraph=" + secondParagraph + ", thirdParagraph="
				+ thirdParagraph + ", firstParagraphT=" + firstParagraphT + ", secondParagraphT=" + secondParagraphT
				+ ", thirdParagraphT=" + thirdParagraphT + ", firstImage=" + firstImage + ", secondImage=" + secondImage
				+ ", thirdImage=" + thirdImage + "]";
	}



}
