package net.guides.springboot.todomanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select().apis(RequestHandlerSelectors.basePackage("net.guides.springboot.todomanagement.controller"))
				.apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("HanviMart API")
				.description("HanviMart API reference for developers")
				.termsOfServiceUrl("http://hanvimart.com")
				.contact("hanvika@gmail.com").license("Hanvi License")
				.licenseUrl("hanvika@gmail.com").version("1.0").build();
	}

}