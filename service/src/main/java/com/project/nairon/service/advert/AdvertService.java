package com.project.nairon.service.advert;
/*
 *@author tobi
 * created on 29/04/2020
 *
 */

import com.project.nairon.models.advert.Advert;
import com.project.nairon.models.advert.AdvertDTO;

import java.sql.Date;
import java.util.List;

public interface AdvertService {


    public Advert createAdvert(Advert advert);

    public void DeleteAdvert(Integer advertId);

    public List<Advert> findAdvertByDate(Date advertId);

    public Advert findAdvertByid(Integer advertId);

    public Advert updateAdvert(Advert advert);

    public List<Advert> findAdvertByUserId(Integer userId);

    public List<Advert> findAll();


}
