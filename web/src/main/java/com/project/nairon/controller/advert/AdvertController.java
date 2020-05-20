package com.project.nairon.controller.advert;
/*
 *@author tobi
 * created on 20/05/2020
 *
 */

import com.project.nairon.models.advert.Advert;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AdvertController {


    @GetMapping("/test")
    public @ResponseBody
    List<String> createAdvert(){

        List<String> result = new ArrayList<>();

        result.add("A");
        result.add("B");
        result.add("C");
        result.add("D");
        result.add("E");

        return result;
    }

}
