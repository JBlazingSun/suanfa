// package com.blazings.suanfa.config;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.bind.annotation.RestController;
// import springfox.documentation.builders.ApiInfoBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.service.Contact;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
// @Configuration
// @EnableSwagger2
// public class Swagger2Config{
//  @Bean
//  public Docket createRestApi() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .apiInfo(apiInfo())
//        .select()
//        .apis(
//            RequestHandlerSelectors.withClassAnnotation(RestController.class))
//        .paths(PathSelectors.any())
//        .build();
//  }
//  private ApiInfo apiInfo() {
//    return new ApiInfoBuilder()
//        .title("测试 title")
//        .description("测试 description")
//        .contact(new Contact("blazings", null, null))
//        .version("1.0")
//        .build();
//  }
// }
