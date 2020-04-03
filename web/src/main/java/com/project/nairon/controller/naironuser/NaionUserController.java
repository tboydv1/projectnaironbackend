package com.project.nairon.controller.naironuser;

import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.naironuser.NaironUserDTO;
import com.project.nairon.service.naironuser.NaironUserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@Tag(name = "Nairon Users", description = "Nairon User API Service By Rabbi")
public class NaionUserController {

    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private NaironUserService naironUserService;

    @GetMapping("/")
    public String test() {
        return "Application is live and running";
    }

    @PostMapping("/user/start")
    public ResponseEntity<NaironUser> registerUserAccount(NaironUserDTO naironUserDTO, HttpRequest request){

        logger.info("Registration user account with information: {}"+ naironUserDTO);
        NaironUser registered = naironUserService.registerNewUserAccount(naironUserDTO);


        return new ResponseEntity<>(registered, HttpStatus.OK);
    }
}
