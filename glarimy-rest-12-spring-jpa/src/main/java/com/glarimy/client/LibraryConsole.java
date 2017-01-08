package com.glarimy.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import com.glarimy.api.Book;

public class LibraryConsole {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient(new ClientConfig());

		Book book = client.target("http://localhost:8080/library/online/book")
				.path("1234").request(MediaType.APPLICATION_JSON)
				.get(Book.class);
		System.out.println(book.getTitle());
		List<Book> books = client
				.target("http://localhost:8080/library/online/book")
				.queryParam("title", "RS").request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Book>>(){});
		System.out.println(books);
	}
}