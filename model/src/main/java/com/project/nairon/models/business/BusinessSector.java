package com.project.nairon.models.business;
/*
 *@author tobi
 * created on 21/04/2020
 *
 */

import javax.persistence.*;

@Entity
@Table(name = "business_sector")
public class BusinessSector {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sectorId;

    private String sectorName;

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }
}
