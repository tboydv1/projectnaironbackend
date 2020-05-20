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
    private BusinessCategory businessSectorId;
    @ManyToOne
    private NaironUser userId;


}
