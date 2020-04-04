/**
 * 
 */
package com.project.nairon.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * @author gbemisola
 *
 */
@Configuration
public class OpenApiConfig  {                                    
	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .components(new Components())
	                .info(new Info().title("Nairon Application API").description(
	                        "This is Nairon API Documentation using springdoc-openapi and OpenAPI 3 . Developed By Gbemi Google").version("Version 1.0.0"));
	    }
    

}