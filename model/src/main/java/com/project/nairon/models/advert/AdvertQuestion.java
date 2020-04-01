package com.project.nairon.models.advert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdvertQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertQuestionId;

    //add advert id

    private String question;

}
