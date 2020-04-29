package com.project.nairon.models.naironuser;

import javax.persistence.*;

/**
 * @author tobi
 */


@Entity
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"email", "phoneNumber"}))
public class NaironUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String email;
    private String phoneNumber;
    private String password;
    private String fullname;
    private String gender;
    private String role;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer naironUserId) {
        this.userId = naironUserId;
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

