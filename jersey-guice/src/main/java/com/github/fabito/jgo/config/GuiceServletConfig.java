package com.github.fabito.jgo.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.github.fabito.jgo.resources.HelloWorldResource;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.spi.service.ServiceFinder;

import java.util.Map;
import java.util.logging.Logger;

public class GuiceServletConfig extends GuiceServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(GuiceServletConfig.class.getName());

    final Map<String, String> params = ImmutableMap.of(
//            ServletContainer.APPLICATION_CONFIG_CLASS, "com.github.fabito.jgo.config.MyApplication",
            "com.sun.jersey.api.json.POJOMappingFeature", "true",
            "com.sun.jersey.config.feature.DisableWADL", "true"
    );

    @Override
    protected Injector getInjector() {

        Stopwatch stopwatch = Stopwatch.createStarted();
        ServiceFinder.setIteratorProvider(new CustomServiceIteratorProvider());
        LOGGER.info("Creating Guice injector");
        final Injector injector = Guice.createInjector(new JerseyServletModule() {
            @Override
            protected void configureServlets() {
//                bind(ObjectifyFilter.class).in(Scopes.SINGLETON);
//                filter("/*").through(ObjectifyFilter.class);
                bind(HelloWorldResource.class).in(Scopes.SINGLETON);;
//                /* bind jackson converters for JSON serialization */
                bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);
                bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);
                serve("/*").with(CustomGuiceContainer.class, params);
            }
        });
        LOGGER.info("Injector created in " + stopwatch.stop());
        return injector;
    }
}
