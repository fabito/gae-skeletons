package com.github.fabito.jdo.config;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class SimpleResource {
    private final SimpleService simpleService;

    @Inject
    SimpleResource(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @Path("/display")
    @GET
    public Response getDisplay() {
        return Response.ok(simpleService.getDisplay()).build();
    }
    
    @POST
    public Response save(Foo foo) {
    	simpleService.saveFoo(foo);
        return Response.created(null).build();
    }
    
}