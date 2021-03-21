package app.core.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.core.apiException.ApiException;
import app.core.entities.AboutContent;
import app.core.entities.Collection;
import app.core.entities.Entry;
import app.core.entities.Item;
import app.core.entities.Slide;
import app.core.repositories.AboutContentRepository;
import app.core.repositories.CollectionRepository;
import app.core.repositories.EntryRepository;
import app.core.repositories.ItemRepository;
import app.core.repositories.SlideRepository;

@Service
@Transactional
public class GeneralService {
	
	@Autowired
	private SlideRepository slideRepository;
	@Autowired
	private CollectionRepository collectionRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private EntryRepository entryRepository;	
	@Autowired
	private AboutContentRepository aboutContentRepository;
	
	public GeneralService() {
	}
	
	public List<Slide> getSlideImages() {
		return  slideRepository.findAll();
	}
	
	public Slide getSlideImage(String original) {
		return slideRepository.getByOriginal(original);
	}
	
	public List<Collection> getCollections(){
		return collectionRepository.findAll();
	}
	
	public List<Item> getItems(){
		return itemRepository.findAll();
	}
	
	public List<Item> getItemsByCollectionName(String collection){
		return itemRepository.findByCollectionName(collection);
	}
	
	public Item getProductByCode(String code) {
		return itemRepository.getByCode(code);
	}
	
	public List<Entry> getEntriesByCode(String code) {
		return entryRepository.findByItemCode(code);
	}
	
	public List<AboutContent> getContnent() throws ApiException {
		try {
			return aboutContentRepository.findAll();
		} catch (Exception e) {
			throw new ApiException("Get content failed!!!");
		}
	}
	

}
