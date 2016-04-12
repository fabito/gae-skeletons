package com.github.fabito.jgo.config;

import com.github.fabito.jgo.resources.HelloWorldResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MyApplication extends Application {
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<>();
		s.add(HelloWorldResource.class);
		return s;
	}



}
