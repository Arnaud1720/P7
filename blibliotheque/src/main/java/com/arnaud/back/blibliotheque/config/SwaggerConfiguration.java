package com.arnaud.back.blibliotheque.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                        .description("gestion d'une blibliothque  API documentation ")
                        .title(" REST API")
                        .build()
                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.arnaud.back.blibliotheque"))
                .paths(PathSelectors.ant(APP_ROOT+"/**"))
                .build();
    }

}
