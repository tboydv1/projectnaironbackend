package com.project.nairon.service.naironuser;

import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.naironuser.NaironUserDTO;

import java.util.List;

/**
 * @author oluwatobi
 */

public interface NaironUserService {

    public NaironUser registerNewUserAccount(NaironUserDTO naironUserDTO);

    public List<NaironUser> findAll();
}
