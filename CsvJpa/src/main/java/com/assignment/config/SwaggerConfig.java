package com.assignment.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//to tell the spring boot that  its a configuration
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
	// docket type function is used to provide springfox function for for
	// configuration
	@Bean
	Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.assignment")).paths(PathSelectors.any()).build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// enabling swagger-ui part for visual documentation
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
