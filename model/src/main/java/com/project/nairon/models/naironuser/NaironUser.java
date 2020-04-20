package com.project.nairon.models.naironuser;

import javax.persistence.*;

/**
 * @author tobi
 */


@Entity
@Table(name =  "nairon_user")
//@IdClass(NaironUserId.class)
public class NaironUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nairon_user_id")
    private Long naironUserId;

//    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullname;

    @Column(name = "business_sector")
    private String businessSector;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "role")
    private String role;

    public Long getNaironUserId() {
        return naironUserId;
    }

    public void setNaironUserId(Long naironUserId) {
        this.naironUserId = naironUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

