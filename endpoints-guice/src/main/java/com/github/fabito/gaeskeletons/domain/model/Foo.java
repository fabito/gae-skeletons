package com.github.fabito.gaeskeletons.domain.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Foo {

	@Id Long id;
	Boolean active = true;

	private Foo() {
		super();
	}
	
}
