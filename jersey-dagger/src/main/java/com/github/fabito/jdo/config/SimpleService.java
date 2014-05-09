package com.github.fabito.jdo.config;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.googlecode.objectify.Key;

@Singleton
public class SimpleService {
	
    private final String display;

    @Inject
    SimpleService(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public Key<Foo> saveFoo(Foo foo) {
        return OfyService.ofy().save().entity(foo).now();
    }

    
}
