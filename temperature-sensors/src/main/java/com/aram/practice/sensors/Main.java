package com.aram.practice.sensors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//public class Main extends AbstractVerticle {
public class Main  {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(SensorVerticle.class,new DeploymentOptions().setInstances(1));
    logger.info(" Main method verticle");

    vertx.eventBus().<JsonObject>consumer("temperature.updates",message ->{
      logger.info("Main >>>{}",message.body().encodePrettily());
    });
  }


}
