package com.github.fabito.jdo.config;

import com.googlecode.objectify.ObjectifyFilter;
import com.leacox.dagger.jersey.DaggerContainer;
import com.leacox.dagger.servlet.DaggerServletContextListener;

public class DaggerServletConfig extends DaggerServletContextListener {

    @Override
    protected Class<?>[] getBaseModules() {
        return new Class<?>[]{SimpleModule.class};
    }

    @Override
    protected Class<?>[] getRequestScopedModules() {
        return new Class<?>[0];
    }

    @Override
    protected void configureServlets() {
    	filterRegex("/*").through(ObjectifyFilter.class);
        serve("/*").with(DaggerContainer.class);
    }

}
