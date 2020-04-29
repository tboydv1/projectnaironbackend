package com.project.nairon.models.business;
/*
 *@author tobi
 * created on 21/04/2020
 *
 */

import com.project.nairon.models.naironuser.NaironUser;

import javax.persistence.*;

@Entity
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer businessId;
    private String name;
    private String websiteUrl;
    @OneToOne
    private BusinessSector businessSectorId;
    @ManyToOne
    private NaironUser userId;

    public BusinessSector getBusinessSectorId() {
        return businessSectorId;
    }

    public void setBusinessSectorId(BusinessSector businessSectorId) {
        this.businessSectorId = businessSectorId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}
