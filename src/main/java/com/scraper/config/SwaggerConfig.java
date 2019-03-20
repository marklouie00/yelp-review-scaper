package com.scraper.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author mark.louie.perez
 * @since 3.05.2019
 *
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.scraper.controller")).paths(regex("/.*")).build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("APIs", "Resful API Documentaion", "1.0", "Terms of Service",
				new Contact("Mark", "https://www.linkedin.com/in/mark-louie-perez-8741b5b8/",
						"marklouieperez05@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licesen.html");

		return apiInfo;
	}

}