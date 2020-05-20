package com.project.nairon.models.questionnaire;
/*
 *@author tobi
 * created on 18/05/2020
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @ToString.Exclude
    @JsonIgnore
    private Integer id;
    private String type;

    private String brandName;

    @ElementCollection
    @CollectionTable(name = "device_versions",joinColumns = @JoinColumn(name = "device_id"))
    @Column(name = "version")
    private List<String> version;

}
