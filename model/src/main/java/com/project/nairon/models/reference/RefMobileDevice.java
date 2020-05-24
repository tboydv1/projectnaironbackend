package com.project.nairon.models.reference;
/*
 *@author tobi
 * created on 18/05/2020
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ref_mobile_devices")
public class RefMobileDevice {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @ToString.Exclude
    @JsonIgnore
    private Integer id;

    private String brandName;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @CollectionTable(name = "ref_device_versions",joinColumns = @JoinColumn(name = "device_id"))
    @Column(name = "version")
    private List<String> version;

    @ManyToOne()
    @JoinColumn(name = "ref_ad_creation_id")
    @ToString.Exclude
    private RefAdsCreation refAdsCreation;

}
