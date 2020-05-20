package com.project.nairon.controller.naironuser;

import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.naironuser.NaironUserDTO;
import com.project.nairon.service.naironuser.NaironUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import java.util.logging.Logger;

/**
 * @author tobi
 */


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Nairon Users", description = "Nairon User API Service By Rabbi")
@Slf4j
public class NaionUserController {



    @Autowired
    private NaironUserService naironUserService;


    @PostMapping("/create")
    public ResponseEntity<NaironUser> registerUserAccount(@RequestBody NaironUserDTO naironUserDTO){

        log.info("Registration user account with information: {}", naironUserDTO);

        NaironUser registered = naironUserService.registerNewUserAccount(naironUserDTO);

        return new ResponseEntity<>(registered, HttpStatus.CREATED);

    }

}
