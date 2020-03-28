package com.colcomparator.controller;

import com.colcomparator.exceptions.NumbeoParsingException;
import com.colcomparator.model.Cities;
import com.colcomparator.model.NumbeoData;
import com.colcomparator.service.CostOfLivingNumbeoParserService;
import com.colcomparator.service.CostOfLivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Numbeo key jr5prcv99u730v

@RestController
public class CostOfLivingController {

    //dependency injection
    @Autowired
    CostOfLivingService costOfLivingService;
    @Autowired
    CostOfLivingNumbeoParserService numbeoParserSvc;

    @GetMapping("city")
    public String getCityData(@RequestParam String cityName){
        return costOfLivingService.getNumbeoData(cityName);
    }

    @GetMapping("cityComparator")
    public NumbeoData getCityData(@RequestParam String cityName, @RequestParam String cityName2,
                                  @RequestParam String country1, @RequestParam String country2,
                                  @RequestParam double amount1, @RequestParam double amount2, @RequestParam String currency)
            throws NumbeoParsingException {
        return numbeoParserSvc.getNumbeoData(country1, country2, cityName, cityName2, amount1, amount2, currency);
    }

    @GetMapping("indices")
    public String getIndicesInfo(@RequestParam String city, @RequestParam String country){
        return costOfLivingService.getIndicesNumbeo(city, country);
    }

    @GetMapping("cityPrices")
    public String getCityPrices(@RequestParam String city, @RequestParam String country){
        return costOfLivingService.getCitiesPrices(city, country);
    }
    @GetMapping("cities")
    public List<String> getAvailableCities(){
        return costOfLivingService.getAvailableCities();
    }


    @GetMapping("allData")
    public List<String> getColData(@RequestParam String cityName, @RequestParam String cityName2,
                                   @RequestParam String country1, @RequestParam String country2) throws NumbeoParsingException {

        return costOfLivingService.getAllData(cityName, cityName2, country1, country2);
    }
}
