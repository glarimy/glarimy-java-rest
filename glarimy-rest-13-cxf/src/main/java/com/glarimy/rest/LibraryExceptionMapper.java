package com.glarimy.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.glarimy.api.BookNotFoundException;
import com.glarimy.api.DuplicateBookException;
import com.glarimy.api.InvalidBookException;

@Provider
public class LibraryExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable t) {
		t.printStackTrace();
		if (t instanceof BookNotFoundException)
			return Response.status(404).build();
		if (t instanceof DuplicateBookException)
			return Response.status(412).build();
		if (t instanceof InvalidBookException)
			return Response.status(400).build();
		return Response.status(500).build();
	}

}
