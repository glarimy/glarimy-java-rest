package com.glarimy.lib.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glarimy.lib.api.Author;
import com.glarimy.lib.api.Book;
import com.glarimy.lib.api.Publisher;

public class BookDAO {
	private Map<Integer, Book> stock;
	private static BookDAO instance;

	private BookDAO() {
		stock = new HashMap<>();
		Book book = new Book();
		Author author = new Author();
		author.setName("Krishna Mohan Koyya");
		author.setEmail("krishna@glarimy.com");

		Publisher publisher = new Publisher();
		publisher.setName("GTS");
		publisher.setPhoneNumber(9731423166L);
		book.setIsbn(1234);
		book.setTitle("JAX-RS Unleashed");
		book.setPublisher(publisher);
		book.getAuthor().add(author);
		stock.put(1234, book);

	}

	public static synchronized BookDAO getInstance() {
		if (instance == null)
			instance = new BookDAO();
		return instance;
	}

	public void create(Book book) {
		stock.put(book.getIsbn(), book);
	}

	public Book read(int isbn) {
		return stock.get(isbn);
	}

	public List<Book> read() {
		return new ArrayList<Book>(stock.values());
	}
}
