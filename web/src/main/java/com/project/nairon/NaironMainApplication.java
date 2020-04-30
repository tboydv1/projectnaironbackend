package com.project.nairon;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tobi
 */

@SpringBootApplication(scanBasePackages = "com.project.nairon")
@EnableTransactionManagement
public class NaironMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaironMainApplication.class);
    }

}
