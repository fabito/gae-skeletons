package com.github.fabito.gaeskeletons.spark;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class FooApplication implements spark.servlet.SparkApplication {

	@Override
	public void init() {

		get(new Route("/foos") {
			@Override
			public Object handle(Request request, Response response) {
				return "Hello Foo World!";
			}
		});
		
	}

}