package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import app.core.apiException.ApiException;
import app.core.entities.AboutContent;
import app.core.entities.Collection;
import app.core.entities.Item;
import app.core.entities.Slide;
import app.core.services.AdminService;
import app.core.util.PayLoad;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	@PostMapping(path = "/updateAboutUs", consumes = {"multipart/form-data"})
	public AboutContent updateAboutUs(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.updateAboutUs(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	
	@GetMapping("/getAboutUs")
	public AboutContent getAboutUs(@RequestHeader String token) {
		try {
			return adminService.getContnent();
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
	
	@PostMapping(path = "/updateFooter", consumes = {"multipart/form-data"})
	public AboutContent updateFooter(@RequestHeader String token,  @ModelAttribute PayLoad payload) {
		try {
			return adminService.updateFooter(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	@GetMapping("/getFooter")
	public String getFooter(@RequestHeader String token) {
		try {
			return adminService.getFooter();
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	
	@PostMapping(path = "/uploadSlideImage", consumes = {"multipart/form-data"})
	public Slide uploadSlideImage(@RequestHeader String token,  @ModelAttribute PayLoad payload){
		try {
			return adminService.uploadSlideImage(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	
	@DeleteMapping("/deleteSlideImage/{id}")
	public int deleteSlideImage(@RequestHeader String token, @PathVariable int id) {
		try {
			return adminService.deleteSlideImage(id);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
	@DeleteMapping("/deleteCollection/{id}")
	public int deleteCollection(@RequestHeader String token, @PathVariable int id) {
		try {
			return adminService.deleteCollection(id);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
	
	@PostMapping(path = "/addCollection", consumes = {"multipart/form-data"})
	public Collection addCollection(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.addCollection(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	@PostMapping(path = "/updateCollection", consumes = {"multipart/form-data"})
	public Collection updateCollection(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.updateCollection(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	
	@PostMapping(path = "/addItem", consumes = {"multipart/form-data"})
	public Item addItem(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.addItem(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	
	@PostMapping(path = "/updateItem", consumes = {"multipart/form-data"})
	public Item updateItem(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.updateItem(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	
	@DeleteMapping("/deleteItem/{id}")
	public int deleteItem(@RequestHeader String token, @PathVariable int id) {
		try {
			return adminService.deleteItemById(id);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	@PostMapping("/bulkUpload")
	public String bulkUpload(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
				String chk = adminService.bulkUpload(payload);
			 if (chk == "both")
				 return "OK";
			 else if (chk == "first")
				 throw new ResponseStatusException(HttpStatus.CONFLICT,"action failed - Zip file invalid");
			 else if (chk =="second")
				 throw new ResponseStatusException(HttpStatus.CONFLICT,"action failed - Excel file invalid");
			 else 
				 throw new ResponseStatusException(HttpStatus.CONFLICT,"action failed - files invalid");
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
}
