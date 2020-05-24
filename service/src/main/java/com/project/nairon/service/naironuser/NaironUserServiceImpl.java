package com.project.nairon.service.naironuser;

import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.naironuser.NaironUserDTO;
import com.project.nairon.repository.naironuser.NaironUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author oluwatobi
 */

@Service
public class NaironUserServiceImpl implements NaironUserService {

    @Autowired
    private NaironUserRepository naironUserRepository;


    @Override
    public NaironUser registerNewUserAccount(NaironUserDTO naironUserDTO) {

        NaironUser naironUser = new NaironUser();
        naironUser.setEmail(naironUserDTO.getEmail());
        naironUser.setPassword(naironUserDTO.getPassword());
        naironUser.setPhoneNumber(naironUserDTO.getPhoneNumber());
//        naironUser.setRole("USER");

        return naironUserRepository.save(naironUser);
    }

    @Override
    public List<NaironUser> findAll() {
        return naironUserRepository.findAll();
    }
}
