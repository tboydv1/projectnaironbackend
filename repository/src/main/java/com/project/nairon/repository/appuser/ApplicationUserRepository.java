package com.project.nairon.repository.appuser;

import com.project.nairon.models.appuser.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer>  {

}
