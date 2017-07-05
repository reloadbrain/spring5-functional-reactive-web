package com.spring5.reactive.playground;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class ApplicationConfig {

    @Bean
    MessageService messageService() {
        return new MessageService();
    }

    @Bean
    RouterFunction<?> mainRouterFunction(final MessageHandler messageHandler) {
        return MessageRouter.doRoutes(messageHandler);
    }

    @Bean
    MessageHandler messageHandler(final MessageService messageService) {
        return new MessageHandler(messageService);
    }
}
