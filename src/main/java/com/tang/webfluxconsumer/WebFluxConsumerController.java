package com.tang.webfluxconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxConsumerController {

  @Autowired
  private WebFluxConsumerService service;

  @GetMapping("/getMessage")
  public Mono<String> message() {
    return service.getMessage();
  }
}
