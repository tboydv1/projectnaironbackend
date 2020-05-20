package com.project.nairon.models.business;
/*
 *@author tobi
 * created on 18/05/2020
 *
 */

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private BusinessCategory category;
}
