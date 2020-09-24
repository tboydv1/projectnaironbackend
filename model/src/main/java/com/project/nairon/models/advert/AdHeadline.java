package com.project.nairon.models.advert;
/*
 *@author tobi
 * created on 24/05/2020
 *
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdHeadline {

    private String headline1;
    private String headline2;
    private String description1;
    private String description2;
    private String displayUrl;
    private String imageUrl;
}
