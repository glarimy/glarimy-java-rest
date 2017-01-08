package com.glarimy.lib.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lib")
public class LibraryController {

	@PUT
	@Path("/book")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response create(Book book) {
		System.out.println("Received " + book.getTitle());
		return Response.ok().build();
	}

	@GET
	@Path("/book/{isbn}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response find(@PathParam("isbn") int isbn) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle("Java-" + isbn);
		return Response.ok().entity(book).build();
	}

	@GET
	@Path("/book")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response find(@QueryParam("title") String isbn,
			@QueryParam("publisher") String publisher) {
		Book book = new Book();
		book.setTitle("Java-" + isbn);
		return Response.ok().entity(book).build();
	}

	@POST
	@Path("/book")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response update(Book book) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/book/{isbn}")
	public Response remove() {
		return Response.ok().build();
	}
}
