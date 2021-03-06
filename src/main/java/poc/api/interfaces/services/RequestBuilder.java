package poc.api.interfaces.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestBuilder {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public <T> ResponseEntity<T> executeRequest(String url, HttpMethod method, Class<T> returnType, 
			MultiValueMap<String, String> headerParams){
	    HttpEntity<T> request = new HttpEntity<T>(headerParams);
	    ResponseEntity<T> response = restTemplate.exchange(url, method, request, returnType);
		return response;
	}
}
