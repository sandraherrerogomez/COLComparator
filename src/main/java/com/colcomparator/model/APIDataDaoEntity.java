package com.colcomparator.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "coliving")
@Data
@Builder
public class APIDataDaoEntity {

    public APIDataDaoEntity(String city, String pricesdata, String indexesdata){
        this.city=city;
        this.pricesdata=pricesdata;
        this.indexesdata=indexesdata;
    }

    public APIDataDaoEntity(){
    }

    @Id
    private String city;
    private String pricesdata;
    private String indexesdata;

}
