package com.project.nairon.models.naironuser;

import lombok.Data;

import javax.persistence.*;

/**
 * @author tobi
 */


@Entity
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"email", "phoneNumber"}))
@Data
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

    public NaironUser(){

        this.role = "ROLE_USER";
    }



}

