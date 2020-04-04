package com.colcomparator.service;

import com.colcomparator.exceptions.NumbeoParsingException;
import com.colcomparator.model.NumbeoData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class CostOfLivingNumbeoParserService {
    private RestTemplate restTemplate= new RestTemplateBuilder().build();

    public NumbeoData getNumbeoData(String country1, String country2, String city1, String city2, double reqAmount1, double reqAmount2, String currency) throws NumbeoParsingException {

        String URL= "https://www.numbeo.com/cost-of-living/compare_cities.jsp?country1="
                +country1+"&country2="+country2+"&city1="+city1+"&city2="+city2 + "&amount="+reqAmount1+"&displayCurrency="+currency;
        try {
            Document doc = Jsoup.connect(URL).get();
            String city2Amount = doc.select(".light_box").get(0).childNodes().get(1).childNodes().get(0).toString();
            String temp = city2Amount.substring(0, city2Amount.length()-4);
            temp = temp.replace(",", "");
            double numbeoCity2Amount= Double.parseDouble(temp);
            NumbeoData data= NumbeoData.builder().amountCity1Numbeo(reqAmount1)
                                                    .amountCity2Numbeo(numbeoCity2Amount).city1Numbeo(city1).city2Numbeo(city2).build();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return NumbeoData.builder().build();
        }

    }
}
