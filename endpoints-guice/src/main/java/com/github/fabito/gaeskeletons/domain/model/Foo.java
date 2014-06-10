package com.github.fabito.gaeskeletons.domain.model;

import java.util.Date;

import org.joda.time.DateTime;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Foo {

	private @Id Long id;
	private Boolean active = true;
	private DateTime createdOn = new DateTime();
	private Date updatedOn = new Date();

	private Foo() {
		super();
	}
	
}
