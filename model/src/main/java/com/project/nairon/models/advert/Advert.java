package com.project.nairon.models.advert;


import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.questionnaire.Questionnaire;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author tobi
 */
@Entity
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private NaironUser userId;

    @OneToOne(mappedBy = "advert", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private AdvertBudget advertBudgetId;

    public Integer getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Integer advertId) {
        this.advertId = advertId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlacementType() {
        return placementType;
    }

    public void setPlacementType(String placementType) {
        this.placementType = placementType;
    }

    public String getHeadlines() {
        return headlines;
    }

    public void setHeadlines(String headlines) {
        this.headlines = headlines;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDisplayFormat() {
        return displayFormat;
    }

    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }

    public String getIspTechnology() {
        return ispTechnology;
    }

    public void setIspTechnology(String ispTechnology) {
        this.ispTechnology = ispTechnology;
    }

    public String getProductUniqueDesc() {
        return productUniqueDesc;
    }

    public void setProductUniqueDesc(String productUniqueDesc) {
        this.productUniqueDesc = productUniqueDesc;
    }

    public String getBusinessCategories() {
        return businessCategories;
    }

    public void setBusinessCategories(String businessCategories) {
        this.businessCategories = businessCategories;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDevices() {
        return devices;
    }

    public void setDevices(String devices) {
        this.devices = devices;
    }

    public NaironUser getUserId() {
        return userId;
    }

    public void setUserId(NaironUser userId) {
        this.userId = userId;
    }

    public AdvertBudget getAdvertBudgetId() {
        return advertBudgetId;
    }

    public void setAdvertBudgetId(AdvertBudget advertBudgetId) {
        this.advertBudgetId = advertBudgetId;
    }


    public String getMobileBrands() {
        return mobileBrands;
    }

    public void setMobileBrands(String mobileBrands) {
        this.mobileBrands = mobileBrands;
    }

    public String getDesktopBrands() {
        return desktopBrands;
    }

    public void setDesktopBrands(String desktopBrands) {
        this.desktopBrands = desktopBrands;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Advert{");
        sb.append("advertId=").append(advertId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", ageRange='").append(ageRange).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", placementType='").append(placementType).append('\'');
        sb.append(", headlines='").append(headlines).append('\'');
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", displayFormat='").append(displayFormat).append('\'');
        sb.append(", ispTechnology='").append(ispTechnology).append('\'');
        sb.append(", productUniqueDesc='").append(productUniqueDesc).append('\'');
        sb.append(", businessCategories='").append(businessCategories).append('\'');
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", devices='").append(devices).append('\'');
        sb.append(", mobileBrands='").append(mobileBrands).append('\'');
        sb.append(", desktopBrands='").append(desktopBrands).append('\'');
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
