package com.ciandt.cocacola.gaevanillajersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableList;

@Path("/foos")
public class FooResource {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method.
	 * 
	 * @return List of all entities persisted.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Foo> listFoos() {
		return ImmutableList.of(new Foo(), new Foo(), new Foo(), new Foo());
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 * 
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Foo getFoo(@QueryParam("id") Long id) {
		return new Foo();
	}
}