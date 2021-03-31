package app.core.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import app.core.apiException.ApiException;
import app.core.entities.AboutContent;
import app.core.entities.Collection;
import app.core.entities.Item;
import app.core.entities.Purchase;
import app.core.entities.PurchaseEntry;
import app.core.entities.Slide;
import app.core.entities.Stock;
import app.core.entities.Trans;
import app.core.entities.User;
import app.core.services.AdminService;
import app.core.util.PayLoad;
import app.core.util.TransactionForm;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping(path = "/updateAboutUs", consumes = { "multipart/form-data" })
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

	@PostMapping(path = "/updateFooter", consumes = { "multipart/form-data" })
	public AboutContent updateFooter(@RequestHeader String token, @ModelAttribute PayLoad payload) {
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

	@PostMapping(path = "/uploadSlideImage", consumes = { "multipart/form-data" })
	public Slide uploadSlideImage(@RequestHeader String token, @ModelAttribute PayLoad payload) {
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

	@PostMapping(path = "/addCollection", consumes = { "multipart/form-data" })
	public Collection addCollection(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.addCollection(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@PostMapping(path = "/updateCollection", consumes = { "multipart/form-data" })
	public Collection updateCollection(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.updateCollection(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@PostMapping(path = "/addItem", consumes = { "multipart/form-data" })
	public Item addItem(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.addItem(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@PostMapping(path = "/updateItem", consumes = { "multipart/form-data" })
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

	@PostMapping(path = "/bulkUpload", consumes = { "multipart/form-data" })
	public String bulkUpload(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.bulkUpload(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@PostMapping(path = "/addVariation", consumes = { "multipart/form-data" })
	public Stock addVariation(@RequestHeader String token, @ModelAttribute PayLoad payload) {
		try {
			return adminService.addVariation(payload);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@DeleteMapping("/deleteVariation/{code}/{variation}")
	public Stock deleteVariation(@RequestHeader String token, @PathVariable String code,
			@PathVariable String variation) {
		try {
			return adminService.deleteVariation(code, variation);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@PostMapping("/addTransaction")
	public Trans addTransaction(@RequestHeader String token, @ModelAttribute TransactionForm tf) {
		try {
			return adminService.addTransaction(tf);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@DeleteMapping("/removeTransaction/{id}")
	public String removeTransaction(@RequestHeader String token, @PathVariable int id) {
		try {
			return adminService.removeTransaction(id);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTransaction")
	public Trans updateTransaction(@RequestHeader String token, @ModelAttribute TransactionForm tf) {
		try {
			return adminService.updateTransaction(tf);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@GetMapping("/getUsers")
	public List<User> getUsers(@RequestHeader String token) {
		try {
			return adminService.getUsers();
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@PostMapping(path = "/updateUser", consumes = { "multipart/form-data" })
	public User updateUser(@RequestHeader String token, @ModelAttribute User user) {
		try {
			return adminService.updateUser(user);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@GetMapping("/getOrders")
	public List<Purchase> getOrders(@RequestHeader String token) {
		try {
			return adminService.getOrders();
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@GetMapping("/getOrderDetails")
	public List<PurchaseEntry> getOrderDetails(@RequestHeader String token) {
		try {
			return adminService.getOrderDetails();
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	
	@GetMapping("/getOrderDetailsById/{id}")
	public List<PurchaseEntry> getOrderDetailsById(@RequestHeader String token, @PathVariable int id) {
		try {
			return adminService.getOrderDetailsById(id);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateOrder")
	public Purchase updateOrder(@RequestHeader String token, @ModelAttribute Purchase purchase,
			@RequestParam String time) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
			LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
			purchase.setWiredate(dateTime);
			return adminService.updateOrder(purchase);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public Purchase deleteOrder(@RequestHeader String token, @PathVariable int id) {
		try {
			return adminService.deleteOrder(id);
		} catch (ApiException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getLocalizedMessage());
		}
	}
}
