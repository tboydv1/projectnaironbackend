package com.project.nairon.models.customer;

import lombok.Data;

import javax.persistence.*;

/**
 * @author tobi
 */


@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    private String password;
    private String fullName;
    private String gender;





}

