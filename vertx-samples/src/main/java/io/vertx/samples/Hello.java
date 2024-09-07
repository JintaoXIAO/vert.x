package io.vertx.samples;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

import java.util.logging.Logger;

public class Hello extends AbstractVerticle {

  private static final Logger LOGGER = Logger.getLogger(Hello.class.getName());

  public void start() throws Exception {
    var eventBus = vertx.eventBus();
    eventBus.consumer("user.login", msg -> {
      System.out.println("message received: " + msg.body());
    });

    eventBus.publish("user.login", "login event");
  }

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new Hello());
  }
}
