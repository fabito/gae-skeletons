package com.github.fabito.gaeskeletons.spark;

import java.util.Set;

import javax.inject.Inject;

import spark.servlet.SparkApplication;

public class CompositeSparkApplication implements SparkApplication {
	
	private Set<SparkApplication> sparkApplications;

	@Inject
	public CompositeSparkApplication(Set<SparkApplication> sparkApplications) {
		super();
		this.sparkApplications = sparkApplications;
	}
	
	@Override
	public void init() {
		for (SparkApplication app : sparkApplications) {
			app.init();
		}
	}
	
	public void addApplication(SparkApplication app) {
		sparkApplications.add(app);
	}

}