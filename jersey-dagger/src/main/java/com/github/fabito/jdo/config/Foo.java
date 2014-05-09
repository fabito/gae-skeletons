package com.github.fabito.jdo.config;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Foo {

	@Id Long id;
	String name;
	String description;
	
}
