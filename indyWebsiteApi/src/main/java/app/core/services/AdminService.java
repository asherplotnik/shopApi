package app.core.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import javax.transaction.Transactional;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import app.core.apiException.ApiException;
import app.core.entities.AboutContent;
import app.core.entities.Collection;
import app.core.entities.Item;
import app.core.entities.Slide;
import app.core.repositories.AboutContentRepository;
import app.core.repositories.CollectionRepository;
import app.core.repositories.ItemRepository;
import app.core.repositories.SlideRepository;
import app.core.util.PayLoad;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AboutContentRepository aboutContentRepository;
	@Autowired
	private SlideRepository slideRepository;
	@Autowired
	private CollectionRepository collectionRepository;
	@Autowired
	private ItemRepository itemRepository;

	@Value("${imgbb.api.key}")
	private String imgbbApiKey;

	public AboutContent updateContnent(AboutContent content) throws ApiException {
		try {
			content.setId(1);
			return aboutContentRepository.save(content);
		} catch (Exception e) {
			throw new ApiException("Update content failed!!!");
		}
	}

	public AboutContent getContnent() throws ApiException {
		try {
			Optional<AboutContent> opt = aboutContentRepository.findById(1);
			if (opt.isPresent()) {
				return opt.get();
			}
			throw new ApiException("Get content failed!!!");
		} catch (Exception e) {
			throw new ApiException("Get content failed!!!");
		}
	}

	public AboutContent updateFooter(PayLoad content) throws ApiException {
		try {
			AboutContent aboutContent = new AboutContent();
			aboutContent.setId(2);
			aboutContent.setMainTitle(content.getMainTitle());
			aboutContent.setMainTitleT(content.getMainTitleT());
			aboutContent.setFirstParagraph(content.getFirstParagraph());
			aboutContent.setFirstParagraphT(content.getFirstParagraphT());
			return aboutContentRepository.save(aboutContent);
		} catch (Exception e) {
			throw new ApiException("Update footer failed!!!");
		}
	}

	public Slide uploadSlideImage(PayLoad payload) throws ApiException {
		String image1Url = uploadImageToImgbb(payload.getFirstImage());
		if (image1Url == null)
			throw new ApiException("No image!!!");
		Slide slide = new Slide();
		slide.setId(Integer.parseInt(payload.getMainTitle()));
		slide.setOriginal(image1Url);
		slide.setThumbnail(image1Url);
		return slideRepository.save(slide);
	}

	public int deleteSlideImage(int id) throws ApiException {
		slideRepository.deleteById(id);
		return id;
	}

	public int deleteCollection(int id) throws ApiException {
		collectionRepository.deleteById(id);
		return id;
	}
	
	public int deleteItemById(int id) throws ApiException {
		itemRepository.deleteById(id);
		return id;
	}

	public String getFooter() throws ApiException {
		try {
			Optional<AboutContent> opt = aboutContentRepository.findById(2);
			if (opt.isPresent()) {
				return opt.get().getFirstParagraph();
			}
			throw new ApiException("Get footer content failed!!!");
		} catch (Exception e) {
			throw new ApiException("Get footer content failed!!!");
		}
	}

	public AboutContent updateAboutUs(PayLoad payload) throws ApiException {
		String image1Url = uploadImageToImgbb(payload.getFirstImage());
		String image2Url = uploadImageToImgbb(payload.getSecondImage());
		String image3Url = uploadImageToImgbb(payload.getThirdImage());
		Optional<AboutContent> opt = aboutContentRepository.findById(1);
		if (opt.isEmpty()) {
			throw new ApiException("Not Found");
		}
		AboutContent content = opt.get();
		content.setMainTitle(payload.getMainTitle());
		content.setMainTitleT(payload.getMainTitleT());
		content.setFirstParagraph(payload.getFirstParagraph());
		content.setFirstParagraphT(payload.getFirstParagraphT());
		content.setSecondParagraph(payload.getSecondParagraph());
		content.setSecondParagraphT(payload.getSecondParagraphT());
		content.setThirdParagraph(payload.getThirdParagraph());
		content.setThirdParagraphT(payload.getThirdParagraphT());
		if (image1Url != null)
			content.setFirstImage(image1Url);
		if (image2Url != null)
			content.setSecondImage(image2Url);
		if (image3Url != null)
			content.setThirdImage(image3Url);
		return content;
	}

	public Collection addCollection(PayLoad payload) throws ApiException {
		String image1Url = uploadImageToImgbb(payload.getFirstImage());
		if (image1Url == null)
			throw new ApiException("No image found!!!");
		Collection content = new Collection();
		content.setName(payload.getMainTitle());
		content.setDescription(payload.getMainTitleT());
		content.setImage(image1Url);
		Optional<Collection> collection = collectionRepository.findByName(payload.getMainTitle());
		if (collection.isPresent())
			throw new ApiException("Collection name exists already!!!");
		return collectionRepository.save(content);
	}

	public Collection updateCollection(PayLoad payload) throws ApiException {
		String image1Url = uploadImageToImgbb(payload.getFirstImage());
		Optional<Collection> opt = collectionRepository.findById(payload.getId());
		if (opt.isEmpty()) {
			throw new ApiException("Not Found");
		}
		Collection content = opt.get();
		Optional<Collection> collection = collectionRepository.findByName(payload.getMainTitle());
		if(collection.isPresent() && collection.get().getId() != content.getId())
			throw new ApiException("Collection name duplicate!!!");
		content.setName(payload.getMainTitle());
		content.setDescription(payload.getMainTitleT());
		if (image1Url != null)
			content.setImage(image1Url);
		return collectionRepository.save(content);
	}

	public Item addItem(PayLoad payload) throws ApiException {
		try {
			String image1Url = uploadImageToImgbb(payload.getFirstImage());
			String image2Url = uploadImageToImgbb(payload.getSecondImage());
			if (image1Url == null)
				throw new ApiException("No image Found");
			if (image2Url == null)
				throw new ApiException("No image Found");
			Item item = new Item();
			if(itemRepository.getByCode(payload.getMainTitle()).isPresent())
				throw new ApiException("Duplicate Code \"" + payload.getMainTitle() + "\" Found !!!");
			item.setCode(payload.getMainTitle());
			Optional<Collection> collection = collectionRepository.findByName(payload.getMainTitleT());
			if (collection.isEmpty())
					throw new ApiException("Collection Dont exists !!!");
			item.setCollection(collection.get());
			item.setDescription(payload.getFirstParagraph());
			item.setSize(Double.parseDouble(payload.getFirstParagraphT()));
			item.setPrice(Double.parseDouble(payload.getSecondParagraph()));
			item.setType(payload.getSecondParagraphT());
			item.setTrending(Boolean.parseBoolean(payload.getThirdParagraph()));
			item.setProductDetails(payload.getThirdParagraphT());
			item.setImage1(image1Url);
			item.setImage2(image2Url);
			return itemRepository.save(item);
		} catch (Exception e) {
			throw new ApiException(e.getLocalizedMessage());
		}
	}
	public Item updateItem(PayLoad payload) throws ApiException {
		try {
			Optional<Item> opt = itemRepository.findById(payload.getId());
			if (opt.isEmpty())
				throw new ApiException("Item not found !!!");
			String image1Url = uploadImageToImgbb(payload.getFirstImage());
			String image2Url = uploadImageToImgbb(payload.getSecondImage());
			if (image1Url == null)
				throw new ApiException("No image Found");
			if (image2Url == null)
				throw new ApiException("No image Found");
			Item item = opt.get();
			Optional<Item> toChk = itemRepository.getByCode(item.getCode());
			if(toChk.isPresent() && toChk.get().getId() != item.getId() ) {
				throw new ApiException("Duplicate Code \"" + payload.getMainTitle() + "\" Found !!!");
			}
			item.setCode(payload.getMainTitle());
			Optional<Collection> optC = collectionRepository.findByName(payload.getMainTitleT());
			if (optC.isEmpty())
				throw new ApiException("Collection Not Found");
			item.setCollection(optC.get());
			item.setDescription(payload.getFirstParagraph());
			item.setSize(Double.parseDouble(payload.getFirstParagraphT()));
			item.setPrice(Double.parseDouble(payload.getSecondParagraph()));
			item.setType(payload.getSecondParagraphT());
			item.setTrending(Boolean.parseBoolean(payload.getThirdParagraph()));
			item.setProductDetails(payload.getThirdParagraphT());
			item.setImage1(image1Url);
			item.setImage2(image2Url);
			return item;
		} catch (Exception e) {
			throw new ApiException(e.getLocalizedMessage());
		}
	}
	
	public String bulkUpload(PayLoad payload) throws ApiException {
		try {
			System.out.println(payload.getFirstImage().getOriginalFilename());
			System.out.println(payload.getSecondImage().getOriginalFilename());		
			boolean first = handleExcelFile(payload.getFirstImage());
			boolean second = handleZipFile(payload.getSecondImage());
			if (first && second)
				return "both";
			if (first)
				return "first";
			if (second)
				return "second";
			return "none";
		} catch (Exception e) {
			throw new ApiException(e.getLocalizedMessage());
		}
	}

	private String uploadImageToImgbb(MultipartFile image) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);
			MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
			body.add("image", image.getResource());
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
			String serverUrl = "https://api.imgbb.com/1/upload?key=" + imgbbApiKey;
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, requestEntity, String.class);
			String json = response.getBody();
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
			JSONObject data = (JSONObject) jsonObject.get("data");
			return (String) data.get("url");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	
	private boolean handleExcelFile(MultipartFile fileM) throws ApiException{
		try(FileInputStream file = (FileInputStream)fileM.getInputStream(); 
			Workbook workbook = new XSSFWorkbook(file);) {
			Sheet sheet = workbook.getSheetAt(0);
			sheet.shiftRows(1,sheet.getLastRowNum() + 1, -1);
			for (Row row : sheet) {
				Item item = new Item();
				if(itemRepository.getByCode(row.getCell(1).getRichStringCellValue().getString()).isPresent()) {
					throw new ApiException("Duplicate Code \"" + row.getCell(1).getRichStringCellValue().getString() + "\" Found !!!");
				}
				item.setCode(row.getCell(1).getRichStringCellValue().getString());
				String collection = row.getCell(2).getRichStringCellValue().getString();
				Optional<Collection> optC = collectionRepository.findByName(collection);
				if (optC.isEmpty())
						throw new ApiException("Collection Dont exists !!!");
				item.setCollection(collectionRepository.findByName(collection).get());
				item.setDescription(row.getCell(3).getRichStringCellValue().getString());
				item.setSize(row.getCell(4).getNumericCellValue());
				item.setPrice(row.getCell(5).getNumericCellValue());
				item.setType(row.getCell(6).getRichStringCellValue().getString());
				item.setTrending(Boolean.parseBoolean(row.getCell(7).getRichStringCellValue().getString()));
				item.setImage1(row.getCell(8).getRichStringCellValue().getString());
				item.setImage2(row.getCell(9).getRichStringCellValue().getString());
				itemRepository.save(item);
			}
		} catch (IOException e) {
			throw new ApiException(" Excel File Invalid ");
		} 
		
		return false;
	}
	private boolean handleZipFile(MultipartFile file) {
		return false;
	}
	
}
