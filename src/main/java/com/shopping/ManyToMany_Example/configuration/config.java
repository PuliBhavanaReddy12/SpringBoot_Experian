package com.shopping.ManyToMany_Example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class config {
    //instead of looking at everything(default),swagger looks at this docket bean to know what it needs to do
    @Bean
    public Docket swaggerConfiguration() { // set properties in it
        // .select creates a builder, obj of class  ApiSelectorBuilder --
        // it has methods that customize how we want swagger to behave
        //build() method creates a docket

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(regex("/customer/product.*")) //configuring paths -- only select paths with pattern customer/product/*
                //error paths are not included.
                .apis(RequestHandlerSelectors.basePackage("com.shopping")) //only looks at this package
                .build()
                .apiInfo(apiDetails()); //adding application metadata
    }
    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Shopping API",
                "Sample Spring boot API with many to many and swagger implementation",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("bhavana","http://javabrains.io","a@b.com"),
                "API License",
                "http://javabrains.io",
                Collections.emptyList());

    }
}
