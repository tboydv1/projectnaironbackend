package com.project.nairon.models.naironuser;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author tobi
 */

//web validation constrains added

@Data
public class NaironUserDTO {

        @Email
        @NotNull
        private String email;
        @NotNull
        private String phoneNumber;
        @NotNull
        private String password;
        private String fullname;
        private String businessSector;
        private String businessName;
        private String gender;
        private String role;

}
