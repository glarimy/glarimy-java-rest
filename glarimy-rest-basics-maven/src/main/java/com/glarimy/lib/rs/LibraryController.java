package com.glarimy.lib.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lib")
public class LibraryController {

	@GET
	@Path("/book/{isbn}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response find(@PathParam("isbn") int isbn) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle("Java-" + isbn);
		return Response.ok().entity(book).build();
	}
}
