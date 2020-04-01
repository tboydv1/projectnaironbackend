package com.project.nairon.models.naironuser;

import javax.persistence.*;

@Entity
@Table(name =  "NaironUser")
@IdClass(NaironUserId.class)
public class NaironUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long naironUserId;

    @Id
    private String email;

    private String phoneNumber;

    private String password;

    private String fullname;

    private String businessSector;

    private String businessName;

    private String gender;

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

