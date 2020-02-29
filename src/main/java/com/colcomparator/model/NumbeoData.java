package com.colcomparator.model;

import lombok.Builder;
import lombok.Data;

@Data //Provides getters and setters
@Builder // Provides builder pattern
public class NumbeoData {
    private String city1;
    private String city2;
    private double amountCity1;
    private double amountCity2;
    private Currency currency;
}
