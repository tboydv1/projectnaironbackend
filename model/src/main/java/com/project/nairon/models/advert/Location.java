package com.project.nairon.models.advert;
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

    @ElementCollection
    @CollectionTable(name = "city", joinColumns = @JoinColumn(name = "location_id"))
    @Column(name = "city_name")
    private List<String> cities;

    @ManyToMany
    @JoinTable(name = "advert_has_location",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "advert_id")
    )
    private List<Advert> advertList;

}
