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


    public Long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(Long advertiserId) {
        this.advertiserId = advertiserId;
    }

    public NaironUser getNaironUserId() {
        return naironUserId;
    }

    public void setNaironUserId(NaironUser naironUserId) {
        this.naironUserId = naironUserId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
