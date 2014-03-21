package com.github.fabito.gaeskeletons.togglz;

import org.togglz.appengine.repository.DatastoreStateRepository;
import org.togglz.appengine.repository.MemcacheStateRepository;
import org.togglz.appengine.user.UserServiceUserProvider;
import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.user.UserProvider;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.users.UserServiceFactory;

public class MyTogglzConfiguration implements TogglzConfig {

	public Class<? extends Feature> getFeatureClass() {
		return MyFeatures.class;
	}

	public StateRepository getStateRepository() {
		return new MemcacheStateRepository(new DatastoreStateRepository(
				DatastoreServiceFactory.getDatastoreService()));
	}

	public UserProvider getUserProvider() {
		return new UserServiceUserProvider(UserServiceFactory.getUserService());
	}

}
