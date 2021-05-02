package com.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class MainVerticle extends AbstractVerticle {

  private static Logger logger = LoggerFactory.getLogger(MainVerticle.class);

  @Override
  public void start() {
    vertx.createHttpServer().requestHandler(req -> req.response().end("Hello World")).listen(8888);
  }

  public static void main(String[] args){
    Vertx.vertx().deployVerticle(new MainVerticle(), handler -> {
      if(handler.succeeded()){
        logger.info("Verticle is deployed");
      } else {
        logger.error("Deployment of verticle has failed");
      }
    });
  }
}
