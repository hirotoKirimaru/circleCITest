package com.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.utils.Utils.LOG_MESSAGE;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestApiUtils {

	final RestTemplate restTemplate = new RestTemplate(); 
	
	public <T> T doGet(String url, Class<T> clazz) {
		log.info(Utils.getMethodName() + LOG_MESSAGE.LOG_START.getMessage());
		try {
			return restTemplate.getForObject(url, clazz);
		} finally {
			log.info(Utils.getMethodName() + LOG_MESSAGE.LOG_END.getMessage());
		}
	}
	
	public <T> String doPost(String url, T param) {
		log.info(Utils.getMethodName() + LOG_MESSAGE.LOG_START.getMessage());
		try {
			return restTemplate.postForObject(url, param, String.class);
		} finally {
			log.info(Utils.getMethodName() + LOG_MESSAGE.LOG_END.getMessage());
		}
	}
}