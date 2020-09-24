package com.project.nairon.models.advert;


import com.project.nairon.models.naironuser.NaironUser;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * @author tobi
 */

@Entity
@Data
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String title;
    private String ageRange;
    private String gender;
    private String placementType;
    private String displayFormat;
    private Date startDate;
    private Date endDate;

    @CreationTimestamp
    private Date createdOn;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private NaironUser userId;

    @OneToOne(mappedBy = "advert", cascade={CascadeType.MERGE})
    private AdvertBudget advertBudget;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @CollectionTable(name = "ad_headlines", joinColumns = @JoinColumn(name = "advert_id"))
    private List<AdHeadline> adHeadlineList;


    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    @CollectionTable(name = "ad_isp", joinColumns = @JoinColumn(name = "advert_id"))
    @Column(name = "isp_name")
    private List<String> ispTechnologies;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ad_business_category", joinColumns = @JoinColumn(name = "advert_id"))
    @Column(name = "category_name")
    private List<String> adBusinessCategories;

    @ManyToMany
    @JoinTable(name = "advert_has_location",
                joinColumns = @JoinColumn(name = "advert_id"),
                inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> locationList;



}
