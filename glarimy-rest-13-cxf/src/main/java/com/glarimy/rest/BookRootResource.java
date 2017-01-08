package com.glarimy.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.glarimy.api.Book;
import com.glarimy.api.Library;

@Path("/book")
public class BookRootResource {
	@Autowired
	private Library library;

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response update(@FormParam("isbn") int isbn,
			@FormParam("price") double price) {
		System.out.println("Updating the book " + isbn);
		Book book = library.find(isbn);
		book.setPrice(price);
		library.update(book);
		return Response.ok().entity(book).build();
	}

	@PUT
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response add(Book book) {
		library.add(book);
		return Response.ok().entity(book).build();
	}

	@GET
	@Path("/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@PathParam("isbn") int isbn) {
		Book book = library.find(isbn);
		return Response.ok().entity(book).build();
	}

	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response search(@QueryParam("title") String title) {
		List<Book> books = library.search(title);
		return Response.ok().entity(new GenericEntity<List<Book>>(books) {
		}).build();
	}
}
