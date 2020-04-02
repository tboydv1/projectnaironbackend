package com.project.nairon.repository.naironuser;

import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.repository.RepositoryConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = RepositoryConfig.class)
//@Sql(scripts = {"classpath:/db/insert-users.sql"})
class NaironUserRepositoryTest {


    @Autowired
    private NaironUserRepository naironUserRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void saveNewUserTest(){

        NaironUser newUser = new NaironUser();

        newUser.setFullname("Oluwatobi Omotosho");
        newUser.setEmail("tobi@mail.com");
        newUser.setPhoneNumber("090494849958");
        newUser.setPassword("testpass");

        naironUserRepository.save(newUser);

    }


}