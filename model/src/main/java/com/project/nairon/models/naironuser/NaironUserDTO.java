package com.project.nairon.models.naironuser;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author tobi
 */

//web validation constrains added
public class NaironUserDTO {

        @Email
        @NotNull
        private String email;

        @NotNull
        private String phoneNumber;

        @NotNull
        private String password;

        @NotNull
        private String fullname;

        private String businessSector;

        private String businessName;

        private String gender;

        private String role;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getBusinessSector() {
            return businessSector;
        }

        public void setBusinessSector(String businessSector) {
            this.businessSector = businessSector;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NaironUserDTO{");
        sb.append("email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", fullname='").append(fullname).append('\'');
        sb.append(", businessSector='").append(businessSector).append('\'');
        sb.append(", businessName='").append(businessName).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
