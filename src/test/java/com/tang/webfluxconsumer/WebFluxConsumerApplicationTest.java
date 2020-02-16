package com.tang.webfluxconsumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WebFluxConsumerApplicationTest {

  private WebFluxConsumerApplication application;

  @BeforeEach
  void setUp() {
    application = new WebFluxConsumerApplication();
  }

  @Test
  void notNull() {
    assertThat(application).isNotNull();
  }
}
