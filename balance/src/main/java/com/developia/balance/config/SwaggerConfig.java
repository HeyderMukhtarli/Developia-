package com.developia.balance.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SecurityScheme(
//        name = "Authorization",
//        scheme = "bearer",
//        bearerFormat = "JWT",
//        type = SecuritySchemeType.HTTP,
//        in = SecuritySchemeIn.HEADER
//)
public class SwaggerConfig {
    //todo:fill real data
    @Bean
    public OpenAPI myOpenAPI(){
        Contact contact=new Contact();
        contact.setEmail("haydarmuxtar26@gmail.com");
        contact.setName("haydar");
        contact.setUrl("https://www.bezkoder.com");

        Info info=new Info()
                .title("Demo app")
                .version("1.0")
                .contact(contact)
                .description("This API exposes to manage tutorials")
                .termsOfService("https://www.bezkoder.com/terms");

        return new OpenAPI().info(info);


    }
}
