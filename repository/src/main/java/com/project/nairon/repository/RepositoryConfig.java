package com.project.nairon.repository;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * @author oluwatobi
 */

@Configuration
@ComponentScan("com.project.nairon")
@EnableJpaRepositories(basePackages = "com.project.nairon.repository")
@EntityScan("com.project.nairon.models")
@EnableAutoConfiguration
public class RepositoryConfig {
}
