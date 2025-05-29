package com.maricel.api.LojaDoSeuManoel.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Loja Do Seu Manoel API")
                        .description("API de Loja Do Seu Manoel")
                        .version("v1.0"));
    }
}