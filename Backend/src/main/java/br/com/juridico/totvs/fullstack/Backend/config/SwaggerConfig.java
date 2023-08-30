package br.com.juridico.totvs.fullstack.Backend.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("Projeto Full-Stack - Pontos Turísticos API")
                        .description("API de Pontos Turísticos")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .version("1.0")
                )
                .components(new Components().addSecuritySchemes("Bearer",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))
                );
    }
}