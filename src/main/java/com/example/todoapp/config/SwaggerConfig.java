package com.example.todoapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Todo App",
                version = "1"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Serveur Environnement INT - VM N°1"
                )
        }
)
public class SwaggerConfig {

}
