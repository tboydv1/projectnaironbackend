package com.project.nairon.models.reference;
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
@Table(name = "ref_ad_creation")
@Data
public class RefAdsCreation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection()
    @CollectionTable(name = "ref_business_category", joinColumns = @JoinColumn(name = "ref_ad_creation_id"))
    @Column(name = "category_name")
    private List<String> businessCategories;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "refAdsCreation")
    private List<RefMobileDevice> refMobileDeviceList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "refAdsCreation")
    private List<RefDesktopDevice> refDesktopDeviceList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection()
    @CollectionTable(name = "ref_isp", joinColumns = @JoinColumn(name = "ref_ad_creation_id"))
    @Column(name = "isp_name")
    private List<String> ispTechnologies;

}
