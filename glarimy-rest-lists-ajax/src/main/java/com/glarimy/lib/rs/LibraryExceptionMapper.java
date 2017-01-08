package com.glarimy.lib.rs;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.glarimy.lib.api.BookNotFoundException;
import com.glarimy.lib.api.InvalidBookException;
import com.glarimy.lib.api.LibraryException;

@Provider
public class LibraryExceptionMapper implements
		ExceptionMapper<LibraryException> {
	@Override
	public Response toResponse(LibraryException e) {
		if (e instanceof InvalidBookException)
			return Response.status(304).build();
		else if (e instanceof BookNotFoundException)
			return Response.status(404).build();
		else
			return Response.status(500).build();
	}
}
