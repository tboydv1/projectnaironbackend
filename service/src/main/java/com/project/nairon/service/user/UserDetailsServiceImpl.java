package com.project.nairon.service.user;

import com.project.nairon.models.appuser.ApplicationUser;
import com.project.nairon.repository.appuser.ApplicationUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {


    ApplicationUserRepository applicationUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {

        this.applicationUserRepository = applicationUserRepository;
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("SEARCHING THE DB FOR USER BY USERNAME '{}'", username);
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);


        if(applicationUser == null || !applicationUser.isActive())
            throw new UsernameNotFoundException(String.format("APPLICATION USER'%s' NOT FOUND", username));
        User user = null;

//
        if(applicationUser.getRole().equals(role)){

            user = new User(applicationUser.getUsername(),
                    bCryptPasswordEncoder.encode(applicationUser.getPassword()),
                    applicationUser.getAuthorities());

        }
        else if
        (applicationUser.getAuthorities().toString().equals("[ROLE_ADMIN]")) {

            user = new User(applicationUser.getUsername(),
                    applicationUser.getPassword() ,
                    applicationUser.getAuthorities());
        }else{
            user = new User(applicationUser.getUsername(),
                    applicationUser.getPassword(), applicationUser.getAuthorities());
        }

        return user;
    }    }
}
