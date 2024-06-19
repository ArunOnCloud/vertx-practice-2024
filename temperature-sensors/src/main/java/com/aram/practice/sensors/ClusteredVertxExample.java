package com.aram.practice.sensors;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClusteredVertxExample {

    private static final Logger logger = LoggerFactory.getLogger(ClusteredVertxExample.class);

    public static void main(String[] args) {
        Vertx.clusteredVertx(new VertxOptions()).onSuccess(vertx->{
            vertx.deployVerticle(new SensorVerticle());
        }).onFailure(failure->{
            logger.error("Failed ",failure);
        });
    }
}
