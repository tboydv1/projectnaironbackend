package com.project.nairon.models.advertiser;

import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.wallet.Wallet;

import javax.persistence.*;

/**
 * @author tobi
 */

@Entity
@Table(name = "advertiser")
public class Advertiser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertiserId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private NaironUser naironUserId;

    //add advertiser wallet id variable here
    @OneToOne
    @JoinColumn(name = "walet_id")
    private Wallet wallet;

}
