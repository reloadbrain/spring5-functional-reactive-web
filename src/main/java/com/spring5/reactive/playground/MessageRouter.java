package com.spring5.reactive.playground;

import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class MessageRouter {

    public static RouterFunction<?> doRoutes(final MessageHandler messageHandler) {
        return route(GET("/message/{id}"),
                    request -> {
                        Mono<Message>
                                message =
                                    Mono.just(
                                            new Message(request.pathVariable("id"), UUID.randomUUID().toString()));

                        return ok().body(fromPublisher(message, Message.class));
                    })
                .and(route(GET("/message"), messageHandler::handleMessage))
                .and(route(GET("/messages"), messageHandler::handleMessages));
    }
}

