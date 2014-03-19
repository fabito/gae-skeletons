package com.github.fabito.jgo.config;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.github.fabito.jgo.resources.HelloWorldResource;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceServletContextListener;
import com.googlecode.objectify.ObjectifyFilter;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
    	
    	final Map<String, String> params = new HashMap<String, String>();

    	return Guice.createInjector(new JerseyServletModule() {

            @Override
            protected void configureServlets() {
            	bind(ObjectifyFilter.class).in(Scopes.SINGLETON);
            	filter("/*").through(ObjectifyFilter.class);      	
            	
            	/* bind the REST resources */
                bind(HelloWorldResource.class).in(Scopes.SINGLETON);;
                //bind(FooRepository.class).to(FooObjectifyRepository.class).in(Scopes.SINGLETON);

                /* bind jackson converters for JAXB/JSON serialization */
                bind(MessageBodyReader.class).to(JacksonJsonProvider.class).in(Scopes.SINGLETON);
                bind(MessageBodyWriter.class).to(JacksonJsonProvider.class).in(Scopes.SINGLETON);
                
                serve("/*").with(GuiceContainer.class, params);
            }
        });
    }
}
