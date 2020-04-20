package com.project.nairon.models.admin;


import com.project.nairon.models.naironuser.NaironUser;

import javax.persistence.*;

/**
 * @author tobi
 */

@Entity
public class Admin {


    @Id
    @GeneratedValue()
    private Long adminId;

    @OneToOne
    @JoinColumn(referencedColumnName = "email")
    private NaironUser naironUserEmail;


    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public NaironUser getNaironUserEmail() {
        return naironUserEmail;
    }

    public void setNaironUserEmail(NaironUser naironUserEmail) {
        this.naironUserEmail = naironUserEmail;
    }
}
