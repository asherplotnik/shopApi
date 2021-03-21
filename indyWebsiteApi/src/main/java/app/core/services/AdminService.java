package app.core.services;

import java.util.Optional;
import javax.transaction.Transactional;
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
import app.core.entities.Slide;
import app.core.repositories.AboutContentRepository;
import app.core.repositories.CollectionRepository;
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
		Slide slide = new Slide();
		slide.setId(Integer.parseInt(payload.getMainTitle()));
		slide.setOriginal(image1Url);
		slide.setThumbnail(image1Url);
		return slideRepository.save(slide);
	}
	
	public int deleteSlideImage(int id)throws ApiException {
		slideRepository.deleteById(id);
		return id;
	}
	
	public int deleteCollection(int id)throws ApiException {
		collectionRepository.deleteById(id);
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
		content.setFirstImage(image1Url);
		content.setSecondImage(image2Url);
		content.setThirdImage(image3Url);
		return content;
	}
	public Collection addCollection(PayLoad payload) throws ApiException {
		String image1Url = uploadImageToImgbb(payload.getFirstImage());
		Collection content = new Collection();
		content.setName(payload.getMainTitle());
		content.setDescription(payload.getMainTitleT());
		content.setImage(image1Url);
		return collectionRepository.save(content);
	}
	public Collection updateCollection(PayLoad payload) throws ApiException {
		String image1Url = uploadImageToImgbb(payload.getFirstImage());
		Optional<Collection> opt = collectionRepository.findById(payload.getId());
		if (opt.isEmpty()) {
			throw new ApiException("Not Found");
		}
		Collection content = opt.get();
		content.setName(payload.getMainTitle());
		content.setDescription(payload.getMainTitleT());
		content.setImage(image1Url);
		return collectionRepository.save(content);
	}
	
	

	private String uploadImageToImgbb(MultipartFile image) throws ApiException {
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
			throw new ApiException(e.getLocalizedMessage());
		}
	}
}
