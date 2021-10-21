package br.com.roseai.sistemaloja.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI buildOpenAPI() {
        var info = getInfo();
        return new OpenAPI().info(info);
    }

    private Info getInfo() {
        var license = getLicense();
        return new Info()
                .title("API Sistema Loja")
                .description("API responsável pelos dados do sistema de controle de estoque e vendas.")
                .version("1.0.0-SNAPSHOT")
                .license(license);
    }

    private License getLicense() {
        return new License()
                .name("Apache License Version 2.0")
                .url("https://www.apache.org/license/LICENSE-2.0\"");
    }
}
