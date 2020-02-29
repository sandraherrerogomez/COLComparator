package com.colcomparator.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CostOfLivingService {
    private RestTemplate restTemplate= new RestTemplateBuilder().build();
    public String getNumbeoData(String cityName){
        String URL="http://www.numbeo.com/api/city_prices?api_key=jr5prcv99u730v&query="+cityName+"&currecy=EUR&use_estimated=true";
        return this.restTemplate.getForObject(URL, String.class);
    }
}