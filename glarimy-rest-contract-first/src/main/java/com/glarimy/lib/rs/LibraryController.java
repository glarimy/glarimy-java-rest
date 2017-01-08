package com.glarimy.lib.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.glarimy.lib.api.Book;
import com.glarimy.lib.api.BookNotFoundException;
import com.glarimy.lib.api.InvalidBookException;
import com.glarimy.lib.api.Library;
import com.glarimy.lib.api.LibraryException;
import com.glarimy.lib.biz.GlarimyLibrary;

@Path("/lib")
public class LibraryController {
	private Library library;

	public LibraryController() {
		library = GlarimyLibrary.getInstance();
	}

	@PUT
	@Path("/book")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response create(Book book) {
		try {
			library.add(book);
			return Response.ok().build();
		} catch (InvalidBookException ibe) {
			return Response.status(401).build();
		} catch (LibraryException le) {
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/book/{isbn}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response find(@PathParam("isbn") int isbn) {
		try {
			Book book = library.find(isbn);
			return Response.ok().entity(book).build();
		} catch (BookNotFoundException bnfe) {
			return Response.status(404).build();
		} catch (LibraryException le) {
			return Response.status(500).build();
		}
	}
}
