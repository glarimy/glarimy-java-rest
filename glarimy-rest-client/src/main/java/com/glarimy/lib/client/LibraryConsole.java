package com.glarimy.lib.client;

import java.io.File;
import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import com.glarimy.lib.api.Author;
import com.glarimy.lib.api.Book;
import com.glarimy.lib.api.Publisher;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class LibraryConsole {
	public static void main(String[] args) {
		Book book = new Book();
		Author author = new Author();
		author.setName("Krishna Mohan Koyya");
		author.setEmail("mohan@glarimy.com");

		Publisher publisher = new Publisher();
		publisher.setName("GTS");
		publisher.setPhoneNumber(9731423166L);
		book.setIsbn(2345);
		book.setTitle("JAX-RS Client Development");
		book.setPublisher(publisher);
		book.getAuthor().add(author);

		ClientConfig config = new DefaultClientConfig();
		config.getClasses().add(JacksonJaxbJsonProvider.class);
		Client client = Client.create(config);

		final HTTPBasicAuthFilter filter = new HTTPBasicAuthFilter("koyya",
				"1234");
		client.addFilter(filter);
		WebResource resource = client.resource(getBaseURI());

		ClientResponse response = resource.path("lib").path("book")
				.type(MediaType.APPLICATION_XML)
				.put(ClientResponse.class, book);
		System.out.println(response.getStatus());

		response = resource.path("lib").path("book").path("1234")
				.type(MediaType.APPLICATION_XML).get(ClientResponse.class);
		System.out.println(response.getStatus());
		Book result = response.getEntity(Book.class);
		System.out.println(result.getTitle());

		response = resource.path("lib").path("book")
				.type(MediaType.APPLICATION_XML).get(ClientResponse.class);
		System.out.println(response.getStatus());
		List<Book> books = response.getEntity(new GenericType<List<Book>>() {
		});
		System.out.println(books.get(1).getTitle());

		MultiPart multiPart = new FormDataMultiPart().field("isbn", "1234");
		FileDataBodyPart part = new FileDataBodyPart("file",
				new File("emp.png"));
		part.setContentDisposition(FormDataContentDisposition.name("file")
				.fileName("emp.png").build());
		multiPart.bodyPart(part);
		response = resource.path("lib").path("book").path("cover")
				.type(MediaType.MULTIPART_FORM_DATA)
				.post(ClientResponse.class, multiPart);
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/jaxrs/glarimy")
				.build();
	}
}
