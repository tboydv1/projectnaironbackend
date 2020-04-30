package com.project.nairon.controller.advert;

import com.project.nairon.models.advert.Advert;
import com.project.nairon.service.advert.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/*
 *@author tobi
 * created on 29/04/2020
 *
 */
@RestController
@RequestMapping("/api/advert")
public class AdvertController {

    @Autowired
    private AdvertService advertService;


    Logger logger = Logger.getLogger(getClass().getName());


    @PostMapping("/create")
    public ResponseEntity<Advert> createNewAdvert(@RequestBody  Advert advert){

        logger.info(""+advert);
        Advert savedAdvert = advertService.createAdvert(advert);

        return new ResponseEntity<>(savedAdvert, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Advert>> findAll(){

        List<Advert> adverts  = advertService.findAll();

        return  new ResponseEntity(adverts, HttpStatus.OK);
    }

}
