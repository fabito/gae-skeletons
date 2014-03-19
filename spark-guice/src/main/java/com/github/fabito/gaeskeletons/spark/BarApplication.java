package com.github.fabito.gaeskeletons.spark;

import static spark.Spark.get;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.servlet.SparkApplication;

public class BarApplication implements SparkApplication {

	@Override
	public void init() {
		get(new Route("/bars") {
			@Override
			public Object handle(Request request, Response response) {
				return "Hello Bars World!";
			}
		});
	}

}
