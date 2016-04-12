package com.github.fabito.jgo.resources;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Singleton
public class HelloWorldResource {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("q") String q) {
		return Response.ok(ImmutableMap.of(
                "id", "134124",
                "name", "fabio",
                "q", q)
        ).build();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAsTxt() {
		return Response.ok("Hello!").build();
	}

}
