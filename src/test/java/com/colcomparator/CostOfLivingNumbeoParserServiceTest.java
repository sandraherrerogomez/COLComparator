package com.colcomparator;

import com.colcomparator.exceptions.NumbeoParsingException;
import com.colcomparator.model.NumbeoData;
import com.colcomparator.service.CostOfLivingNumbeoParserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CostOfLivingNumbeoParserServiceTest {

  @Autowired
  CostOfLivingNumbeoParserService svc;

  @Test
  //Test existing cities with enough data
  public void testValidData() throws NumbeoParsingException {
    int reqAmount1 = 50000;
  NumbeoData result = svc.getNumbeoData("Spain", "Ireland", "Madrid", "Dublin", reqAmount1,
          65000, "EUR");

  assert result.getAmountCity1Numbeo() == reqAmount1;
  assert result.getAmountCity2Numbeo() > 0;
  }

  @Test
  //Test city with not enough data
  public void testNotEnoughDataCity() throws NumbeoParsingException {
    int reqAmount1 = 50000;
    NumbeoData result = svc.getNumbeoData("Spain", "Spain", "Aviles", "Torremolinos", reqAmount1,
            65000, "EUR");
    // result should be an empty object
    assert result.getAmountCity1Numbeo() == 0;
    assert result.getAmountCity2Numbeo() == 0;
    assert result.getCity1Numbeo() == null;
    assert result.getCity2Numbeo() == null;
  }

}
