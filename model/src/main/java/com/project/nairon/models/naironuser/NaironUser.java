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
    @Column(name="id")
    private Integer id;
    private String email;
    private String phoneNumber;
    private String password;
    private String fullName;
    private String gender;

    public NaironUser(){


    }



}

