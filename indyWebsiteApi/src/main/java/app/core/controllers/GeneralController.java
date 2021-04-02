package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import app.core.apiException.ApiException;
import app.core.entities.AboutContent;
import app.core.entities.Collection;
import app.core.entities.Stock;
import app.core.entities.Trans;
import app.core.entities.Item;
import app.core.entities.Slide;
import app.core.services.GeneralService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class GeneralController {
	
	@Autowired
	GeneralService generalService;
	
	@GetMapping("/getSlideImages")
	public List<Slide> getSlideImages() {
		List<Slide> list = generalService.getSlideImages();
		return list;
	}
	
	@GetMapping("/getCollections")
	public List<Collection> getCollections() {
		List<Collection> list = generalService.getCollections();
		if (list.size()> 0) {
			return list;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT,"Empty List");
		}
	}

	@GetMapping("/getItemsByCollectionName/{collection}")
	public List<Item> getCollections(@PathVariable String collection) {
		List<Item> list = generalService.getItemsByCollectionName(collection);
		if (list.size()> 0) {
			return list;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT,"Empty List");
		}
	}
	

	@GetMapping("/getProductByCode/{code}")
	public Item getProductByCode(@PathVariable String code) {
		Item item = generalService.getProductByCode(code);
		if (item != null) {
			return item;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT,"Product Not Found");
		}
	}
	
	@GetMapping("/getStockByCode/{code}")
	public List<Stock> getEntriesByCode(@PathVariable String code) {
		List<Stock> items = generalService.getStockByCode(code);
		if (items != null) {
			return items;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT,"Product Not Found");
		}
	}
	@GetMapping("/getStockByCodeAndVariation/{code}/{variation}")
	public Stock getStockByCodeAndVariation(@PathVariable String code,@PathVariable String variation) {
		Stock item = generalService.getStockByCodeAndVariation(code,variation);
		if (item != null) {
			return item;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT,"Product Not Found");
		}
	}
	
	@GetMapping("/getAboutUs")
	public List<AboutContent> getAboutUs() {
		try {
			return generalService.getContnent();
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
	
	@GetMapping("/getItems")
	public List<Item> getItems() {
		try {
			return generalService.getItems();
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
	@GetMapping("/getStock")
	public List<Stock> getStock() {
		try {
			return generalService.getStock();
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
	
	@GetMapping("/getStockById/{id}")
	public List<Stock> getStock(@PathVariable int id) {
		try {
			return generalService.getStockById(id);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
	
	@GetMapping("/getTransactions/{code}")
	public List<Trans> getTransactions(@PathVariable String code) {
		try {
			return generalService.getTransactions(code);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}

}
