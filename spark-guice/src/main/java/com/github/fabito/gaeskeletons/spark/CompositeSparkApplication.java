package com.github.fabito.gaeskeletons.spark;

import java.util.Arrays;
import java.util.List;

import spark.servlet.SparkApplication;

public class CompositeSparkApplication implements SparkApplication {
	
	private List<SparkApplication> sparkApplications;

	public CompositeSparkApplication(List<SparkApplication> sparkApplications) {
		super();
		this.sparkApplications = sparkApplications;
	}

	public CompositeSparkApplication(SparkApplication... sparkApplications) {
		super();
		this.sparkApplications = Arrays.asList(sparkApplications);
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