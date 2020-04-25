package com.mymovies.service;

import com.mymovies.dto.CreditsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditService implements ICreditService {

	@Value("${resource.api.url}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(CreditService.class);
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public CreditsDTO getAPI_Credit(String movie_id) {

		CreditsDTO credits = null;
		
		try {
			credits = restTemplate.getForObject(BASE_URL+movie_id+"/credits"+API_KEY+Language, CreditsDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error: getAPI_Credit: " + e);
		}

		return credits;

	}

}
