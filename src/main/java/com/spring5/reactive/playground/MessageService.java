package com.spring5.reactive.playground;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.UUID;

public class MessageService {

    public Mono<Message> getMessage() {
        return Mono.just(new Message(UUID.randomUUID().toString(), "Hello World!"));
    }

    public Flux<Message> getMessages() {
        return Flux.fromIterable(
                Arrays.asList(
                        new Message(UUID.randomUUID().toString(), "Hello World!"),
                        new Message(UUID.randomUUID().toString(), "Hello World, from US!"),
                        new Message(UUID.randomUUID().toString(), "Hello World, How are you?!")
                )
        );
    }
}
