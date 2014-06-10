package com.github.fabito.gaeskeletons.api;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.github.fabito.gaeskeletons.domain.model.Foo;
import com.github.fabito.gaeskeletons.domain.model.FooRepository;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

@Api(name = "foobar", version = "v1", description = "Foo API", 
     clientIds = {com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID}
)
public class FooApiV1 {

    private static final Logger LOGGER = Logger.getLogger(FooApiV1.class.getName());

    private FooRepository repository;

	@Inject
	public FooApiV1(FooRepository repository) {
		super();
		this.repository = repository;
	}

    @ApiMethod(path = "{tenantId}/foos/{id}", httpMethod = "GET")
    public FooResponse get(@Named("tenantId") String tenantId, 
    		@Named("id") String id) {
    	LOGGER.info(id);
    	return new FooResponse();
    }
    
    @ApiMethod(path = "{tenantId}/foos", httpMethod = "POST")
    public FooResponse post(@Named("tenantId") String tenantId, Foo foo) {
    	LOGGER.info(foo.toString());
    	return new FooResponse();
    }
    
}