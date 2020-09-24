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
@Table(name = "ref_desktop_devices")
public class RefDesktopDevice {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @ToString.Exclude
    @JsonIgnore
    private Integer id;
    private String brandName;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @CollectionTable(name = "ref_desktop_versions",joinColumns = @JoinColumn(name = "ref_desktop_devices_id"))
    @Column(name = "version")
    private List<String> version;

    @ManyToOne()
    @JoinColumn(name = "ref_ad_creation_id")
    @ToString.Exclude
    private RefAdsCreation refAdsCreation;

}
