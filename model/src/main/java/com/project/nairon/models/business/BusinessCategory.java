package com.project.nairon.models.business;
/*
 *@author tobi
 * created on 18/05/2020
 *
 */

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class BusinessCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany
    private List<SubCategory> subCategoryList;

}
