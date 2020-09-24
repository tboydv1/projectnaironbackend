package com.project.nairon.repository.customer;

import com.project.nairon.models.customer.Customer;
import com.project.nairon.repository.RepositoryConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tobi
 */


@SpringBootTest(classes = RepositoryConfig.class)
@Sql(scripts = {"classpath:/db/insert-users.sql"})
class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void saveNewUserTest(){

        Customer newUser = new Customer();

        newUser.setFullName("Oluwatobi Omotosho");
        newUser.setEmail("tobi@mail.com");
        newUser.setPhoneNumber("090494849958");
        newUser.setPassword("testpass");
        newUser.setGender("M");

        customerRepository.save(newUser);

    }






}