Funtional Reactive Web with Spring 5 - Still in Milestone realease, but looks like alot of new and exciting features ahead.

Trying out the new RouterFunction instead of the normal @RestController and Spring's Reactor's Mono and Flux

To launch it, run Spring5ReactiveWebApplication.java

There are 3 api available -
  1. /message  - get a message using Mono<Message>
  2. /message/{id} - get a message using Mono<Message>
  3. /messages - get a list of Messages using Flux<Message>

````java
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

````


@RestController/@RequestMapping and RouterFunction are exclusive of each other.

It's quite easy to integrate with RxJava using @RestController, however,
with RouterFunction, I am not quite sure how to integrate RxJava.
It's still in milestone, so the Spring documentation doesn't have any reference to it yet

maybe just as simple as replace Mono<Message> with Single<Message> and Flux<Message> with Flowable<Message>

Also, I will add MongoDB or Cassandra as a backend soon ...


Happy Learning!
