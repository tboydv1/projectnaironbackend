package com.project.nairon.models.advert;



import com.project.nairon.models.business.BusinessCategory;
import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.questionnaire.Device;
import com.project.nairon.models.questionnaire.Location;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

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
    private Integer advertId;

    private String title;
    private String ageRange;
    private String gender;
    private String placementType;
    private String headlines;
    private String imageUrl;
    private String displayFormat;
    private String ispTechnology;
    private String productUniqueDesc;
    private Date startDate;
    private Date endDate;
    @CreationTimestamp
    private Date createdOn;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "advert_has_business_category",
            joinColumns = @JoinColumn(name = "advert_id"),
    inverseJoinColumns = @JoinColumn(name = "business_category_id"))
    private List<BusinessCategory> businessCategories;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "advert_has_device",
            joinColumns = @JoinColumn(name = "advert_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id"))
    private List<Device> deviceList;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "advert_has_location",
            joinColumns = @JoinColumn(name = "advert_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> locationList;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private NaironUser userId;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "budget_id")
    private AdvertBudget advertBudget;

}
