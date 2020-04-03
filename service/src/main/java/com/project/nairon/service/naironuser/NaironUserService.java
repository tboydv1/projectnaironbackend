package com.project.nairon.service.naironuser;

import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.naironuser.NaironUserDTO;

public interface NaironUserService {

    public NaironUser registerNewUserAccount(NaironUserDTO naironUserDTO);
}
