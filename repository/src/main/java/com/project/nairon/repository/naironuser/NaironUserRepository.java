package com.project.nairon.repository.naironuser;


import com.project.nairon.models.naironuser.NaironUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author tobi
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface NaironUserRepository extends JpaRepository<NaironUser, Integer> {
}
