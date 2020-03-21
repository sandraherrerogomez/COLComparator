package com.colcomparator.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CountriesAPI {
    private List<CountryAPIInfo> countries;
}
