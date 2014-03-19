package com.github.fabito.js;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class FooRepository implements Repository {

	public List<Foo> getAll() {
		return ImmutableList.of(new Foo(), new Foo(), new Foo(), new Foo());
	}

	public Foo get(Long id) {
		return new Foo();
	}

}
