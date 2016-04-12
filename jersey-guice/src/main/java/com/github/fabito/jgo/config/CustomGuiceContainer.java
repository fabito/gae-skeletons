package com.github.fabito.jgo.config;

import com.google.common.base.Stopwatch;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.spi.container.WebApplication;

import java.util.logging.Logger;

@Singleton
public class CustomGuiceContainer extends GuiceContainer {

    private static final Logger LOGGER = Logger.getLogger(CustomGuiceContainer.class.getName());

    @Inject
    public CustomGuiceContainer(Injector injector) {
        super(injector);
    }

    @Override
    protected void initiate(ResourceConfig config, WebApplication webapp) {
        LOGGER.info("Initiating Jersey setup");
        Stopwatch stopwatch = Stopwatch.createStarted();
        super.initiate(config, webapp);
        LOGGER.info("Jersey initiated in " + stopwatch.stop());
    }
}
