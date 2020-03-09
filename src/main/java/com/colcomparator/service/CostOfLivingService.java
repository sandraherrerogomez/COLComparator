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

    public String getIndicesNumbeo(String city, String country){
        String URL="http://www.numbeo.com/api/indices?api_key=jr5prcv99u730v&query="+city+", "+country;
        return this.restTemplate.getForObject(URL, String.class);
    }

    public String getCitiesPrices(String city, String country){
        String URL="http://www.numbeo.com/api/city_prices_raw?api_key=jr5prcv99u730v&query="+city+", "+country;
        return this.restTemplate.getForObject(URL, String.class);
    }
}
