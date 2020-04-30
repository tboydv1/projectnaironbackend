package com.project.nairon.models.advert;
/*
 *@author tobi
 * created on 29/04/2020
 *
 */


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Data
public class AdvertDTO {

    private Integer advertId;
    private String title;
    private String ageRange;
    private String gender;
    private String placementType;
    private String headlines;
    private String imageUrl;
    private String displayFormat;
    private String ispTechnology;
    private String productUniqueDesc;
    private String businessCategories;
    private Date startDate;
    private Date endDate;
    private String devices;
    private String mobileBrands;
    private String desktopBrands;
    private String targetLocation;




}
