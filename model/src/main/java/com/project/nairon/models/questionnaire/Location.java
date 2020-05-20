package com.project.nairon.models.questionnaire;
/*
 *@author tobi
 * created on 18/05/2020
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.source.tree.CompilationUnitTree;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @ToString.Exclude
    @JsonIgnore
    private Integer id;
    private String country;
    private String state;
    private String city;

}
