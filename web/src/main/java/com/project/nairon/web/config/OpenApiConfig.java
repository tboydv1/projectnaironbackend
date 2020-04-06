/**
 * 
 */
package com.project.nairon.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * @author gbemisola
 *
 */
@Configuration
public class OpenApiConfig extends WebMvcConfigurationSupport {                                    
	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .components(new Components())
	                .info(new Info().title("Contact Application API").description(
	                        "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
	    }
    
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}