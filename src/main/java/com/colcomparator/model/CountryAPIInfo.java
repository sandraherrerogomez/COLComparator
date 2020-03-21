package com.colcomparator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryAPIInfo {
    private String name;
    private String API;
    private String source;
}
