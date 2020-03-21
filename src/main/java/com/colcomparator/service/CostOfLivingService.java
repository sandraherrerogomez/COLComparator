package com.colcomparator.service;

import com.colcomparator.model.Cities;
import com.colcomparator.model.CountriesAPI;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

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


    public List<String> getAvailableCities(){
        String URLCountries = "http://localhost:8082/countries";
        CountriesAPI countries=this.restTemplate.getForObject(URLCountries, CountriesAPI.class);
        String URL="http://www.numbeo.com/api/cities?api_key=jr5prcv99u730v";
        Cities response=this.restTemplate.getForObject(URL, Cities.class);

        List<String> countriesStr = countries.getCountries().stream().map(cApi -> cApi.getName()).collect(Collectors.toList());
        //Lista de ciudades, que los paises coincidan con los que soportamos
        return response.getCities().stream().filter(city -> countriesStr.contains(city.getCountry())).map(c -> c.getCity()).collect(Collectors.toList());
    }


}
