package com.github.fabito.gaeskeletons.spark;

import javax.inject.Inject;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import spark.servlet.SparkApplication;
import spark.servlet.SparkFilter;

public class SparkGuiceFilter extends SparkFilter {

	private SparkApplication application;
	
	@Inject
	public SparkGuiceFilter(SparkApplication application) {
		super();
		this.application = application;
	}

	@Override
	protected SparkApplication getApplication(FilterConfig filterConfig)
			throws ServletException {
		return application;
	}
	
}