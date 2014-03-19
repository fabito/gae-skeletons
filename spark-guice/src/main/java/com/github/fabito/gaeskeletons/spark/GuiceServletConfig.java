package com.github.fabito.gaeskeletons.spark;

import spark.servlet.SparkApplication;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
    	return Guice.createInjector(new SparkModule(),new ServletModule() {
    	     @Override
    	     protected void configureServlets() {
    	    	 bind(SparkGuiceFilter.class).in(Scopes.SINGLETON);
    	         filter("/*").through(SparkGuiceFilter.class);
    	     }
    	   });
    }
    
    private static class SparkModule extends AbstractModule {
		@Override
		protected void configure() {
			bind(SparkApplication.class).to(Application.class);
		}
    	
    }
}