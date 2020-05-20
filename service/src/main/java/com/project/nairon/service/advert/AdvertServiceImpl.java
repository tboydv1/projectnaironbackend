package com.project.nairon.service.advert;
/*
 *@author tobi
 * created on 29/04/2020
 *
 */

import com.project.nairon.models.advert.Advert;
import com.project.nairon.repository.advert.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {

    private AdvertRepository advertRepository;

    @Autowired
    public AdvertServiceImpl(AdvertRepository advertRepository){

        this.advertRepository = advertRepository;

    }
    @Override
    public Advert createAdvert(Advert advert) {

        return advertRepository.save(advert);
    }

    @Override
    public void DeleteAdvert(Integer advertId) {


        advertRepository.deleteById(advertId);
    }

    @Override
    public List<Advert> findAdvertByDate(Date advertId) {
        return null;
    }


    @Override
    public Advert findAdvertByid(Integer advertId) {
        return advertRepository.findById(advertId).get();
    }

    @Override
    public Advert updateAdvert(Advert advert) {

        return advertRepository.save(advert);
    }

    @Override
    public List<Advert> findAdvertByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<Advert> findAll() {
        return (List<Advert>) advertRepository.findAll();
    }
}
