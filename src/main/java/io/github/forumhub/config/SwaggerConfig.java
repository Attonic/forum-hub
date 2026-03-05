package io.github.forumhub.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI configuracaoOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Forum Hub API")
                        .version("v1.0.0")
                        .description("Documentação interativa do sistema")

                );
    }

}
