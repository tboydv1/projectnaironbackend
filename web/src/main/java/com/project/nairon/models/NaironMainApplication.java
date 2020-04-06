package com.project.nairon.models;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.project.nairon.repository")
public class NaironMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaironMainApplication.class, args);
    }
}
