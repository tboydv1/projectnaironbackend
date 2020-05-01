package com.project.nairon.models.advert;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.questionnaire.Questionnaire;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

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
    private String businessCategories;
    private Date startDate;
    private Date endDate;
    private String devices;
    private String mobileBrands;
    private String desktopBrands;
    private String targetLocation;

    @CreationTimestamp
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private NaironUser userId;

    @OneToOne()
//    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "budget_id")
    @JsonManagedReference
    private AdvertBudget advertBudget;

}
