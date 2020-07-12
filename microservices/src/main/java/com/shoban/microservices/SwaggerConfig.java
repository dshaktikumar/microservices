package com.shoban.microservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    private Contact DEFAULT_CONTACT = new Contact("Shakthi","https://github.com/dshaktikumar/microservices", "dshaktikumar@gmail.com");
    private ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "API Title", "Shoban API Description", "1.0",
            "urn:notermsfornow", DEFAULT_CONTACT,
            "No License", "http://www.abcd.com", Arrays.asList());

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).consumes(new HashSet<>(Arrays.asList("application/json", "application/xml"))).produces(new HashSet<>(Arrays.asList("application/json", "application/xml")));
    }

}
