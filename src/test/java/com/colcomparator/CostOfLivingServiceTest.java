package com.colcomparator;

import com.colcomparator.service.CostOfLivingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CostOfLivingServiceTest {
  @Autowired
  CostOfLivingService svc;

  @Test
  public void testGetIndices(){
    String result = svc.getIndicesNumbeo("Madrid", "Spain");
    assert result.length() > 0;
    assert(result.contains("Madrid, Spain"));
    assert(result.contains("crime_index"));
  }

}
