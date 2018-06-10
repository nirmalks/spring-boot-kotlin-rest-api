package com.example.demo

import io.swagger.models.Path
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2



@Configuration
@EnableSwagger2
class SwaggerConfig  {
	@Bean
	fun api(): Docket {
		return Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.paths(PathSelectors.regex("/api.*"))
				.build()
	}

}