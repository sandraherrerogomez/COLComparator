package com.colcomparator.service;

import com.colcomparator.dao.APIDataDAO;
import com.colcomparator.model.APIDataDaoEntity;
import com.colcomparator.model.Cities;
import com.colcomparator.model.CountriesAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CostOfLivingService {
    @Autowired
    private APIDataDAO dao;

    private RestTemplate restTemplate= new RestTemplateBuilder().build();
    public String getNumbeoData(String cityName){
        String URL="http://www.numbeo.com/api/city_prices?api_key=jr5prcv99u730v&query="+cityName+"&currecy=EUR&use_estimated=true";
        String data = this.restTemplate.getForObject(URL, String.class);
        //dao.save(APIDataDaoEntity.builder().city(cityName).data(data).build());
        return data;
    }

    public String getIndicesNumbeo(String city, String country){
        String URL="http://www.numbeo.com/api/indices?api_key=jr5prcv99u730v&query="+city+", "+country;
        String data = this.restTemplate.getForObject(URL, String.class);
        //dao.save(APIDataDaoEntity.builder().city(city).data(data).build());
        return data;
    }

    public String getCitiesPrices(String city, String country){
        String URL="http://www.numbeo.com/api/city_prices_raw?api_key=jr5prcv99u730v&query="+city+", "+country;
        String data = this.restTemplate.getForObject(URL, String.class);
        //dao.save(APIDataDaoEntity.builder().city(city).data(data).build());
        return data;
    }


    public List<String> getAvailableCities(){
        String URLCountries = "http://localhost:8082/countries";
        CountriesAPI countries=this.restTemplate.getForObject(URLCountries, CountriesAPI.class);
        String URL="http://www.numbeo.com/api/cities?api_key=jr5prcv99u730v";
        Cities response=this.restTemplate.getForObject(URL, Cities.class);

        List<String> countriesStr = countries.getCountries().stream().map(cApi -> cApi.getName()).collect(Collectors.toList());

        return response.getCities().stream().filter(city -> countriesStr.contains(city.getCountry())).map(c -> c.getCity() + " -> " + c.getCountry()).collect(Collectors.toList());
    }

    public List<String> getAllData(String cityName, String cityName2, String country1, String country2){
        List<String> data = new ArrayList();


        String indices1=getIndicesNumbeo(cityName,country1);
        String indices2=getIndicesNumbeo(cityName2,country2);
        data.add(indices1);
        data.add(indices2);
        String cityPrices1 = getCitiesPrices(cityName,country1);
        String cityPrices2 = getCitiesPrices(cityName2,country2);
        data.add(cityPrices1);
        data.add(cityPrices2);
        dao.save(APIDataDaoEntity.builder().city(cityName).indexesdata(indices1).pricesdata(cityPrices1).build());
        dao.save(APIDataDaoEntity.builder().city(cityName2).indexesdata(indices2).pricesdata(cityPrices2).build());
        return data;
    }


}
