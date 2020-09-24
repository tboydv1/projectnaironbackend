package com.project.nairon.repository.customer;


import com.project.nairon.models.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author tobi
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
