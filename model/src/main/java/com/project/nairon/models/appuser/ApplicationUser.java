package com.project.nairon.models.appuser;
/*
 *@author tobi
 * created on 11/05/2020
 *
 */

import com.project.nairon.models.admin.Admin;
import com.project.nairon.models.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.security.SecureRandom;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationUser implements GrantedAuthority {

    @Id
    private Integer id;
    private String username;
    @ToString.Exclude
    private String password;

    private boolean isActive;

    private String role;



    public ApplicationUser(@NotNull Customer applicationUser) {

        this.id = generateId();
        this.username = applicationUser.getEmail();
        this.password = applicationUser.getPassword();
        this.role = "USER";
        //set isActive to false upon creation
        this.isActive = false;
    }

    public ApplicationUser(@NotNull Admin applicationAdmin) {
        this.id = generateId();
        this.username = applicationAdmin.getEmail();
        this.password = applicationAdmin.getPassword();
        this.role = "ADMIN";
        this.isActive = true;
    }

    private Integer generateId(){
        SecureRandom random = new SecureRandom();
        return 4000+ random.nextInt(5999);
    }


    @Override
    public String getAuthority() {
        return role;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        String ROLE_PREFIX = "ROLE_";
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new
                org.springframework.security.core.authority
                        .SimpleGrantedAuthority(ROLE_PREFIX + getAuthority()));
        return list;
    }
}
