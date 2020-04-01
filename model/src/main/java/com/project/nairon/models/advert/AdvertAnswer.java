package com.project.nairon.models.advert;

import javax.persistence.*;

@Entity
public class AdvertAnswer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertAnswerId;

    @OneToOne
    @JoinColumn(name="advertQuestionId")
    private AdvertQuestion advertQuestionId;


    public Long getAdvertAnswerId() {
        return advertAnswerId;
    }

    public void setAdvertAnswerId(Long advertAnswerId) {
        this.advertAnswerId = advertAnswerId;
    }

    public AdvertQuestion getAdvertQuestionId() {
        return advertQuestionId;
    }

    public void setAdvertQuestionId(AdvertQuestion advertQuestionId) {
        this.advertQuestionId = advertQuestionId;
    }
}
