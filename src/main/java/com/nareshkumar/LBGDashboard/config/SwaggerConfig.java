package com.nareshkumar.LBGDashboard.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.nareshkumar.LBGDashboard"))
					.paths(regex("/rest.*"))
					.build()
					.apiInfo(metaInfo());
	}

	/**
	 * Overrides the default API Info
	 * @return apiInfo
	 */
	private ApiInfo metaInfo() {
		
		ApiInfo apiInfo = new ApiInfo("LBG Kanban Dashboard", "Kanban Demo", "1.0", "www.nareshkumar.com"
				,new Contact("Naresh Kumar", "www.nareshkumar.org", "xxxxx@gmail.com") 
				, "Apache License", "www.apache.com");
		
		return apiInfo;
	}

}
