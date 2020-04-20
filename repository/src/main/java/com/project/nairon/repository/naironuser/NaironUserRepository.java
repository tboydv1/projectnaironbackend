package com.project.nairon.repository.naironuser;


import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.models.naironuser.NaironUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tobi
 */

@Repository
public interface NaironUserRepository extends JpaRepository<NaironUser, Long> {
}
