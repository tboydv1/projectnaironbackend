package com.project.nairon.controller.naironuser;

import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.naironuser.NaironUserDTO;
import com.project.nairon.service.naironuser.NaironUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class NaionUserController {

    Logger logger = Logger.getLogger(getClass().getName());


    @Autowired
    private NaironUserService naironUserService;


    @GetMapping("/")
    public String test() {
        return "Application is live and running";
    }


    @PostMapping("/start")
    public ResponseEntity<NaironUser> registerUserAccount(@RequestBody NaironUserDTO naironUserDTO){

        logger.info("Registration user account with information: {}"+ naironUserDTO);

        NaironUser registered = naironUserService.registerNewUserAccount(naironUserDTO);

        return new ResponseEntity<>(registered, HttpStatus.OK);
    }

}
