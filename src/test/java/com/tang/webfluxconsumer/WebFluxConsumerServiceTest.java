package com.tang.webfluxconsumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

@SpringJUnitConfig(classes = { WebFluxConsumerController.class, WebFluxConsumerService.class })
@WebFluxTest()
class WebFluxConsumerServiceTest {

  @Autowired
  private WebTestClient client;

  @BeforeEach
//  void setUp(ApplicationContext context) {
//    client = WebTestClient.bindToApplicationContext(context).build();
//  }
  public void setUp() {
    client = client
        .mutate()
        .responseTimeout(Duration.ofMillis(36000))
        .build();
  }

  @Test
  void getMessage() {
    client.get()
        .uri("/message")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class);
  }
}