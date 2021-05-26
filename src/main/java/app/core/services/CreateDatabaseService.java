package app.core.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.AboutContent;
import app.core.entities.Slide;
import app.core.entities.User;
import app.core.repositories.AboutContentRepository;
//import app.core.repositories.CollectionRepository;
//import app.core.repositories.EntryRepository;
//import app.core.repositories.ItemRepository;
//import app.core.repositories.TransactionRepository;
import app.core.repositories.SlideRepository;
import app.core.repositories.UserRepository;

@Service
@Transactional
public class CreateDatabaseService {
	
	@Autowired
	private SlideRepository slideRepository;
//	@Autowired
//	private CollectionRepository collectionRepository;
//	@Autowired
//	private ItemRepository itemRepository;
//	@Autowired
//	private EntryRepository entryRepository;	
	@Autowired
	private AboutContentRepository aboutContentRepository;
//	@Autowired
//	private TransactionRepository transactionRepository;
	@Autowired
	private UserRepository userRepository;
	
	public void createDatabase() {
		User user = new User();
		user.setAddress("lumpini place 18/552 ratchada-thapra");
		user.setEmail("asherplotnik@gmail.com");
		user.setLevel("admin");
		user.setPassword("KNgzG910zOECsZfSP5Uh2HXGnq9Z5U8cKCLNV2qAYvs=");
		user.setSalt("UkNzaFmfNoyY160P9sjCE8PRhSNE7W");
		user.setPhone("66879037504");
		user.setUsername("asher plotnik");
		userRepository.save(user);
		Slide slide = new Slide();
		slide.setOriginal("https://i.ibb.co/8xYJmQx/DSC01576.jpg");
		slide.setThumbnail("https://i.ibb.co/8xYJmQx/DSC01576.jpg");
		slideRepository.save(slide);
		slide = new Slide();
		slide.setOriginal("https://i.ibb.co/N1nX5nz/DSC01578.jpg");
		slide.setThumbnail("https://i.ibb.co/N1nX5nz/DSC01578.jpg");
		slideRepository.save(slide);
		slide = new Slide();
		slide.setOriginal("https://i.ibb.co/0cXf3Km/DSC01630.jpg");
		slide.setThumbnail("https://i.ibb.co/0cXf3Km/DSC01630.jpg");
		slideRepository.save(slide);
		slide = new Slide();
		slide.setOriginal("https://i.ibb.co/R4WMkx0/DSC01618.jpg");
		slide.setThumbnail("https://i.ibb.co/R4WMkx0/DSC01618.jpg");
		slideRepository.save(slide);
		slide = new Slide();
		slide.setOriginal("https://i.ibb.co/xLKc3YK/DSC01582.jpg");
		slide.setThumbnail("https://i.ibb.co/xLKc3YK/DSC01582.jpg");
		slideRepository.save(slide);
		AboutContent aboutContent = new AboutContent();
		aboutContent.setMainTitle("Indy Fashion");
		aboutContent.setMainTitleT("พเะ่พนร่เพำร่เด าเ่เ่ าสเ่กด");
		aboutContent.setFirstImage("https://i.ibb.co/Km1bNRy/crystal-bead-8mm.jpg");
		aboutContent.setFirstParagraph("buy from us we are the best");
		aboutContent.setFirstParagraphT("ดเ่เกเสาก่า่กวสฟเา่ยรนพ่ิอทเาดวทอกเ่ าสเ่กดสาเ่รพเะ่พนร่เพำร่เพ่ิอทเาดวทอกเ่ าวสดา่เวสเดา่กวสฟเา่ยรนพ่ิอทเาดวทอกเ่ าสเ่กดสพำ\r\n"
				+ " ดเ่เกเสาก่เวสกา่เวสกเ่วดาวสดา่เวสเดา่กวสฟเา่ยรนพ่ิอทเาดวทอกเ่ าสเ่กดสาเ่รพเะ่พนร่เพำร่เด าเ่เ่นรพนพำ");
		aboutContent.setSecondImage("https://i.ibb.co/D5s5nsz/DSC01521a.jpg");
		aboutContent.setSecondParagraph("hi how are you did you like our stuff");
		aboutContent.setSecondParagraphT("สาก่เวสกา่เวสกเ่วดาวสดา่เวสเดา่กะ่พนร่เพำร่เเ่รพเะ่พนร่เพำร่เด าเ่เ่ าสเ่กดสาเ่รพเะ่พนร่เพำร่เด าเ่เ่นรพนพำดเ่เกเสาก่เวสกา่เวสกเ่วดาวสดา่เวฟเา่ยรนพ่ิอทเาดวทอกเ่ าสเ่กดสาเ่รพเะ่พนร่เพำร่เเ่รพเะ่พนร่เพำร่เด าเ่เ่นรพนพำดเ่เกเสาก่เวสก");
		aboutContent.setThirdImage("https://i.ibb.co/7jdK0gg/DSC01548.jpg");
		aboutContent.setThirdParagraph("wholesale price with retail quantity !!!");
		aboutContent.setThirdParagraphT("ะ่พนร่เพำร่เเ่รพเะ่พนร่เพำร่เด าเ่เ่ะ่พะ่พนร่เพนร่เพำร่เด าเ่เ่นร่เพำร่เเ่รพเะ่พนร่เพำร่เด าเ่เ่ะ่พนะ่พนร่เพำร่เด าเ่เ่ะ่พนร่เพำร่เเ่รพเะ่พนร่เพำร่เด าเ่เ่ะ่พนร่เพำร่เเ่รพเะ่พนร่เพำร่เด าเ่เ่นร่เพำร่เเ่รพเะ่พนร่เพำร่เด าเ่เ่ะ่พนร่เพำร่เเ่รพเะ่พนร่เพำร่เด าเ่เ่");
		aboutContentRepository.save(aboutContent);
		aboutContent = new AboutContent();
		aboutContent.setFirstParagraph("asherplotnik@gmail.com");
		aboutContent.setFirstParagraphT("0879037504");
		aboutContent.setMainTitle("https://www.youtube.com/channel/UCOleG6EtOlMMU3lhwIGCgcQ");
		aboutContent.setMainTitleT("https://www.facebook.com/Indy-fashion-101376811323628");
		aboutContentRepository.save(aboutContent);		
	}

}
