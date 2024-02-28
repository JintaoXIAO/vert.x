package io.vertx.it;

import io.vertx.core.impl.VertxBuilder;
import io.vertx.core.spi.VertxServiceProvider;
import io.vertx.core.spi.context.storage.ContextLocal;

public class CustomContextKey implements VertxServiceProvider  {

  public static ContextLocal<Object> CUSTOM_KEY = ContextLocal.registerLocal(Object.class);
  public static volatile boolean initialized;

  @Override
  public void init(VertxBuilder builder) {
    initialized = true;
  }
}
