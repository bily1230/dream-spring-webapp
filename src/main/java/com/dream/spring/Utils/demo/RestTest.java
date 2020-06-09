package com.dream.spring.Utils.demo;


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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RestTemplate 测试实例
 *
 * @author nb
 * 教程 : http://blog.csdn.net/yiifaa/article/details/77939282
 */

public class RestTest {

    public static void main(String[] args) {

        String formUrl = "http://127.0.0.1:8099/rest/form";
        String payLoadUrl = "http://127.0.0.1:8099/rest/payLoad";


        //form表单提交只能用MultiValueMap 不能用Map
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
        multiValueMap.add("name", "小明");
        multiValueMap.add("age", "88");
        HttpHeaders headers = new HttpHeaders();
        // 需要设置contentType 为 application/x-www-form-urlencoded
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(multiValueMap, headers);
        ResponseEntity<Object> form = restTemplate.postForEntity(formUrl, httpEntity, Object.class);


        //FormHttpMessageConverter 添加编码格式


        //PayLoad 提交
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "小黄");
        map.put("age", "99");
        HttpHeaders payHeaders = new HttpHeaders();
        payHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> payEntity = new HttpEntity<Map<String, Object>>(map, payHeaders);
        //添加消息转换器,若不添加消息转换器,则需只能为String
        List<HttpMessageConverter<?>> coverterList = new ArrayList<HttpMessageConverter<?>>();
        coverterList.add(new MappingJackson2HttpMessageConverter());
        coverterList.add(new ByteArrayHttpMessageConverter());
        coverterList.add(new AllEncompassingFormHttpMessageConverter());
        coverterList.add(new ResourceHttpMessageConverter());
        coverterList.add(new StringHttpMessageConverter());
        coverterList.add(new FormHttpMessageConverter());

        restTemplate.setMessageConverters(coverterList);

        ResponseEntity<Object> payLoad = restTemplate.postForEntity(payLoadUrl, payEntity, Object.class);


        System.out.println(form.getBody());
        System.out.println(payLoad.getBody());

    }

}
