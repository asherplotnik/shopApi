package app.core.services;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.AboutContent;
import app.core.entities.Collection;
import app.core.entities.Item;
import app.core.entities.Slide;
import app.core.entities.Stock;
import app.core.entities.Trans;
import app.core.entities.User;
import app.core.repositories.AboutContentRepository;
import app.core.repositories.CollectionRepository;
import app.core.repositories.ItemRepository;
import app.core.repositories.SlideRepository;
import app.core.repositories.UserRepository;

@Service
@Transactional
public class CreateDatabaseService {
	
	@Autowired
	private SlideRepository slideRepository;
	@Autowired
	private AboutContentRepository aboutContentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CollectionRepository collectionRepository;
	@Autowired
	private ItemRepository itemRepository;
	
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
		user = new User();
		user.setAddress("some address");
		user.setEmail("admin@admin.com");
		user.setLevel("admin");
		user.setPassword("a/bGCmR4mWR0LixMRs2Xk03TOovyceoP6cUQYj1fnqM=");
		user.setSalt("F0Y6kgxMNgiTEsbMzWK7th5zi5wtPR");
		user.setPhone("111111111");
		user.setUsername("admin");
		userRepository.save(user);
		Slide slide = new Slide();
		slide.setOriginal("https://i.ibb.co/8M1f4KV/DSC01603.jpg");
		slide.setThumbnail("https://i.ibb.co/8M1f4KV/DSC01603.jpg");
		slideRepository.save(slide);
		slide = new Slide();
		slide.setOriginal("https://i.ibb.co/D8rL7gh/DSC01536.jpg");
		slide.setThumbnail("https://i.ibb.co/D8rL7gh/DSC01536.jpg");
		slideRepository.save(slide);
		slide = new Slide();
		slide.setOriginal("https://i.ibb.co/VmNGKxj/DSC02364.jpg");
		slide.setThumbnail("https://i.ibb.co/VmNGKxj/DSC02364.jpg");
		slideRepository.save(slide);
		slide = new Slide();
		slide.setOriginal("https://i.ibb.co/K5tYmGV/DSC01634.jpg");
		slide.setThumbnail("https://i.ibb.co/K5tYmGV/DSC01634.jpg");
		slideRepository.save(slide);
		slide = new Slide();
		slide.setOriginal("https://i.ibb.co/rdq1cKk/DSC01622.jpg");
		slide.setThumbnail("https://i.ibb.co/rdq1cKk/DSC01622.jpg");
		slideRepository.save(slide);
		slide = new Slide();
		slide.setOriginal("https://i.ibb.co/7NrwdPZ/N-2377.jpg");
		slide.setThumbnail("https://i.ibb.co/7NrwdPZ/N-2377.jpg");
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
		
		Collection collecection = new Collection("Silver", "Silver Collection", "https://i.ibb.co/G5Rs9Zw/DSC01634.jpg");
		collectionRepository.save(collecection);
		collecection = new Collection("Stainless", "Stainless Steel", "https://i.ibb.co/tskgpw3/SC02.jpg");
		collectionRepository.save(collecection);
		collecection = new Collection("Metal", "Metal Collection", "https://i.ibb.co/YRRHyvt/DSC02377-D.jpg");
		collectionRepository.save(collecection);
		collecection = new Collection("D.I.Y", "Do It Yourself", "https://i.ibb.co/5FXypSS/DSC01582.jpg");
		collectionRepository.save(collecection);
		
		
		Item item = new Item("B 0001", "Amazing infinity silver bracelete", "Silver Bracalete", 18.0, 149.99, "BRACELET", false, "https://i.ibb.co/LxZ4Bzy/DSC02497.jpg", "https://i.ibb.co/LxZ4Bzy/DSC02497.jpg");
		Optional<Collection> opt = collectionRepository.findById(1);
		item.setCollection(opt.get());
		Stock stock = new Stock("BLACK", 0, "https://i.ibb.co/LxZ4Bzy/DSC02497.jpg");
		Trans trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		item = new Item("B 0002", "Awsome Beads silver bracelet", "Beads Silver Bracalete", 17.0, 199.99, "BRACELET", false, "https://i.ibb.co/6gk4tMb/DSC01111-D.jpg", "https://i.ibb.co/6gk4tMb/DSC01111-D.jpg");
		item.setCollection(opt.get());
		stock = new Stock("PINK", 0, "https://i.ibb.co/6gk4tMb/DSC01111-D.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		item = new Item("B 0003", "Awsome Pearls silver bracelet", "Pearls Silver Bracalete", 16.0, 299.99, "BRACELET", false, "https://i.ibb.co/G5Rs9Zw/DSC01634.jpg", "https://i.ibb.co/G5Rs9Zw/DSC01634.jpg");
		item.setCollection(opt.get());
		stock = new Stock("WHITE", 0, "https://i.ibb.co/G5Rs9Zw/DSC01634.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		opt = collectionRepository.findById(2);
		item = new Item("N 0001", "Amazing Mens necklace", "Heavy stainless necklace", 16.0, 299.99, "NECKLACE", false, "https://i.ibb.co/tskgpw3/SC02.jpg", "https://i.ibb.co/ygY163f/SC02A.jpg");
		item.setCollection(opt.get());
		stock = new Stock("STAINLESS", 0, "https://i.ibb.co/tskgpw3/SC02.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		item = new Item("P 0001", "Chick Mens Pendant", "Cool stainless pendant", 16.0, 299.99, "PENDANT", false, "https://i.ibb.co/7QXVSq0/DSC02494.jpg", "https://i.ibb.co/tZ7s3Tc/DSC02491.jpg");
		item.setCollection(opt.get());
		stock = new Stock("STAINLESS", 0, "https://i.ibb.co/7QXVSq0/DSC02494.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		opt = collectionRepository.findById(3);
		item = new Item("B 0004", "Amazing Metal bracelet", "Metal bracelet", 16.0, 9.99, "BRACELET", false, "https://i.ibb.co/4Yd7yyv/DSC01555.jpg", "https://i.ibb.co/4Yd7yyv/DSC01555.jpg");
		item.setCollection(opt.get());
		stock = new Stock("GOLDEN", 0, "https://i.ibb.co/4Yd7yyv/DSC01555.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		item = new Item("B 0005", "Awsome Metal bracelet", "Metal bracelet", 16.0, 17.99, "BRACELET", false, "https://i.ibb.co/MCTGjqF/DSC01581.jpg", "https://i.ibb.co/MCTGjqF/DSC01581.jpg");
		item.setCollection(opt.get());
		stock = new Stock("BLUE", 0, "https://i.ibb.co/MCTGjqF/DSC01581.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		stock = new Stock("RED", 0, "https://i.ibb.co/fp8zYMq/DSC01578.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		item = new Item("B 0006", "Dragonfly charm bracelet", "cool charm bracelet", 16.0, 8.99, "BRACELET", false, "https://i.ibb.co/92rCdb6/DSC01544.jpg", "https://i.ibb.co/92rCdb6/DSC01544.jpg");
		item.setCollection(opt.get());
		stock = new Stock("GREY", 0, "https://i.ibb.co/92rCdb6/DSC01544.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		item = new Item("P 0002", "Drop Crustal pendant", "cool drop pendant", 16.0, 58.99, "PENDANT", false, "https://i.ibb.co/my6F8Ht/DSC02377-BB.jpg", "https://i.ibb.co/MPT2JQn/DSC02377-AA.jpg");
		item.setCollection(opt.get());
		stock = new Stock("LAVENDER", 0, "https://i.ibb.co/my6F8Ht/DSC02377-BB.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		stock = new Stock("SMOKEY", 0, "https://i.ibb.co/R9JX6DY/DSC02377-AA.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		opt = collectionRepository.findById(4);
		item = new Item("B 0007", "Amazing Metal bracelet", "Do it yourself bracelet", 16.0, 9.99, "BRACELET", false, "https://i.ibb.co/Vt5b85F/DSC01622.jpg", "https://i.ibb.co/Vt5b85F/DSC01622.jpg");
		item.setCollection(opt.get());
		stock = new Stock("BLACK", 0, "https://i.ibb.co/Vt5b85F/DSC01622.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		item = new Item("B 0008", "Amazing Metal bracelet", "Do it yourself bracelet", 16.0, 29.99, "BRACELET", false, "https://i.ibb.co/5FXypSS/DSC01582.jpg", "https://i.ibb.co/5FXypSS/DSC01582.jpg");
		item.setCollection(opt.get());
		stock = new Stock("RED", 0, "https://i.ibb.co/5FXypSS/DSC01582.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		item = new Item("B 0009", "Amazing Metal bracelet", "Do it yourself bracelet", 16.0, 19.99, "BRACELET", false, "https://i.ibb.co/mz8TkMV/DSC01576.jpg", "https://i.ibb.co/mz8TkMV/DSC01576.jpg");
		item.setCollection(opt.get());
		stock = new Stock("PINK", 0, "https://i.ibb.co/mz8TkMV/DSC01576.jpg");
		trans = new Trans(100, true, LocalDateTime.now(), "initial", -1);
		stock.addTrans(trans);
		item.addStock(stock);	
		itemRepository.save(item);
		System.out.println("initialized Database");
	}

}
