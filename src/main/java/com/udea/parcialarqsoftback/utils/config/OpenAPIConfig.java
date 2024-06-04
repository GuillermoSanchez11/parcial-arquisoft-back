package com.udea.parcialarqsoftback.utils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${application.openapi.server.url}")
    private String serverUrl;


    @Bean
    public OpenAPI myOpenAPI() {
        Server server = new Server();
        server.setUrl(serverUrl);
        server.setDescription("Server URL");


        Info info = new Info()
                .title("PARCIAL ARQSOFT API")
                .version("1.0")
                .description("Esta API expone endpoints para ----."); // TODO: Cambiar la descripción


        return new OpenAPI().info(info).servers(List.of(server));
    }
}
