/*
* Copyright Benchmark Education Company
*
* (C) Copyright Benchmark	All rights reserved.
*
* NOTICE:  All information contained herein or attendant here to is,
*          and remains, the property of Benchmark.  Many of the
*          intellectual and technical concepts contained herein are
*          proprietary to Benchmark. Any dissemination of this
*          information or reproduction of this material is strictly
*          forbidden unless prior written permission is obtained
*          from Benchmark.
*
* ------------------------------------------------------------------------
*
* ========================================================================
* Revision History
* ========================================================================
* DATE	: PROGRAMMER  : DESCRIPTION
* ========================================================================
* DEC 26 2018	: BEC         : CREATED.
* ------------------------------------------------------------------------
*
* ========================================================================
*/
package com.bec.socratesrpt.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SocratesSwaggerConfig extends WebMvcConfigurationSupport  {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.bec.socratesrpt.controller"))
                .paths(regex("/api.*"))
                .build().apiInfo(metaData());
    }
	
	private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Socrates REST API")
                .description("\"This project is all about the REST APIs for Benchmark Universe Reposrting tool\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Sivarama Krishna Kantipudi", "https://app.byndr.com", "skantipudi@intraedge.com"))
                .build();
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
