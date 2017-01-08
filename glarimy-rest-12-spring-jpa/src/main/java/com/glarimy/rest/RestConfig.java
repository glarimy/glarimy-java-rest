package com.glarimy.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class RestConfig extends ResourceConfig {

	public RestConfig() {
		register(RequestContextFilter.class);
		register(BookRootResource.class);
		register(JacksonFeature.class);
	}
}