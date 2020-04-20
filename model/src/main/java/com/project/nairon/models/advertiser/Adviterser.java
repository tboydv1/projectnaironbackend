package com.project.nairon.models.advertiser;

import com.project.nairon.models.naironuser.NaironUser;

import javax.persistence.*;

/**
 * @author tobi
 */

@Entity
public class Adviterser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertiserId;

    @OneToOne
    @JoinColumn(referencedColumnName = "email")
    private NaironUser naironUserEmail;

    //add advertiser wallet id variable here

}
