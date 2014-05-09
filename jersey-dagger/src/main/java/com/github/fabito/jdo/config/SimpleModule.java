package com.github.fabito.jdo.config;

import javax.inject.Singleton;

import com.googlecode.objectify.ObjectifyFilter;
import com.leacox.dagger.jersey.JerseyModule;
import com.leacox.dagger.servlet.ServletModule;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                SimpleService.class,
                SimpleResource.class,
                ObjectifyFilter.class
        },
        includes = {
                ServletModule.class,
                JerseyModule.class
        }
)
public class SimpleModule {
    @Provides
    @Singleton
    public String provideDisplay() {
        return "SimpleDisplay";
    }

    @Provides
    public SimpleService provideSimpleService(String display) {
        return new SimpleService(display);
    }
    
    @Provides
    @Singleton
    public ObjectifyFilter objectifyFilter() {
        return new ObjectifyFilter();
    }
    
}