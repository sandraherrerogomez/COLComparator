package com.colcomparator.model;

import lombok.Builder;
import lombok.Data;

@Data //Provides getters and setters
@Builder // Provides builder pattern
public class NumbeoData {
    private String city1Numbeo;
    private String city2Numbeo;
    private double amountCity1Numbeo;
    private double amountCity2Numbeo;
    private Currency currency;
}
