package com.dream.spring.Utils;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class RestTest {

	public static void main(String[] args) {
		String put = "{\"code\":\"updateCC\", \"name\":\"UPDATE\",\"content\":\"updateCT\", \"order\":9}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<String>(put,headers);
		
		String url = "http://192.168.10.199:8099/test/tput";
		RestTemplate restTemplate = new RestTemplate();
		
		//ResponseEntity<Map> result =  restTemplate.exchange(url+"?name={name}" , HttpMethod.PUT, httpEntity, Map.class,"22");
		ResponseEntity<Object> result = restTemplate.postForEntity(url, put, Object.class);
		System.out.println(result.getBody());

	}

}
