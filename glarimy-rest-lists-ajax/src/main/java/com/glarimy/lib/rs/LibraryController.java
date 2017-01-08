package com.glarimy.lib.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.glarimy.lib.api.Book;
import com.glarimy.lib.api.Library;
import com.glarimy.lib.biz.GlarimyLibrary;

@Path("/lib")
public class LibraryController {
	private Library library;

	public LibraryController() {
		library = new GlarimyLibrary();
	}

	@PUT
	@Path("/book")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response create(Book book) {
		library.add(book);
		return Response.ok().build();
	}

	@GET
	@Path("/book/{isbn}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response find(@PathParam("isbn") int isbn) {
		Book book = library.find(isbn);
		return Response.ok().entity(book).build();
	}

	@GET
	@Path("/book")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response find() {
		List<Book> books = library.list();
		return Response.ok().entity(new GenericEntity<List<Book>>(books) {
		}).build();
	}
}