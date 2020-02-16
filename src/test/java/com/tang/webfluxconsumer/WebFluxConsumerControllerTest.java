package com.tang.webfluxconsumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WebFluxConsumerControllerTest {

  @InjectMocks
  private WebFluxConsumerController controller;

  @Mock
  private WebFluxConsumerService service;

  @Test
  void message() {
    given(service.getMessage()).willReturn(Mono.empty());

    Mono<String> result = controller.message();

    assertThat(result).isEqualTo(Mono.empty());
    verify(service, times(1)).getMessage();
  }

}