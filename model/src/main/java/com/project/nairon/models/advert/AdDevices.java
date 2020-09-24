package com.project.nairon.models.advert;
/*
 *@author tobi
 * created on 24/05/2020
 *
 */

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class AdDevices {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String brandName;

    private String type;

    @ManyToOne
    private Advert advert;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @CollectionTable(name = "ad_device_versions", joinColumns = @JoinColumn(name = "ad_devices_id"))
    @Column(name = "version")
    private List<String> versions;
}
