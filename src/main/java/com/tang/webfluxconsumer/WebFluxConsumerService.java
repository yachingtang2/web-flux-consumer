package com.tang.webfluxconsumer;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebFluxConsumerService {

//  private WebClient client = WebClient.create("http://localhost:8080");

  private final WebClient client;

  public WebFluxConsumerService() {
    this.client = WebClient.builder()
        .baseUrl("http://localhost:8080")
        .build();
  }

  public Mono<String> getMessage() {
    return client.get()
        .uri("/message")
//        .accept(MediaType.TEXT_PLAIN)
        .exchange()
        .flatMap(clientResponse -> clientResponse.bodyToMono(String.class));
  }
}
