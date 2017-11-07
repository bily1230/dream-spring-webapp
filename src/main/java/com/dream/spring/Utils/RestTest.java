package com.dream.spring.Utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.dream.spring.domain.User;



public class RestTest {

	public static void main(String[] args) {
		
		//http://blog.csdn.net/yiifaa/article/details/77939282
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("name", "yyyyyyy");
		map.add("age", "hhhhh");
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		List<HttpMessageConverter<?>> coverterList = new ArrayList<HttpMessageConverter<?>>();
		coverterList.add(new MappingJackson2HttpMessageConverter());
		coverterList.add(new ByteArrayHttpMessageConverter());
		coverterList.add(new AllEncompassingFormHttpMessageConverter());
		coverterList.add(new ResourceHttpMessageConverter());
		coverterList.add(new StringHttpMessageConverter());
		coverterList.add(new FormHttpMessageConverter());
		
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String,String>>(map,headers);
		
		String url = "http://127.0.0.1:8099/test/tput/hhhh";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(coverterList);
		
		
		
		ResponseEntity<Object> result = restTemplate.postForEntity(url, httpEntity, Object.class);
		
		System.out.println(result.getBody());

	}

}
