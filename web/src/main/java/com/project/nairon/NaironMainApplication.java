package com.project.nairon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * @author tobi
 */

@SpringBootApplication(scanBasePackages = "com.project.nairon")
public class NaironMainApplication {


    public static void main(String[] args) {
        SpringApplication.run(NaironMainApplication.class);
    }



}
