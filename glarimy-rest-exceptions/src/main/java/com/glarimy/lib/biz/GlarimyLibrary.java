package com.glarimy.lib.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glarimy.lib.api.Author;
import com.glarimy.lib.api.Book;
import com.glarimy.lib.api.BookNotFoundException;
import com.glarimy.lib.api.DuplicateBookException;
import com.glarimy.lib.api.InvalidBookException;
import com.glarimy.lib.api.Library;
import com.glarimy.lib.api.LibraryException;
import com.glarimy.lib.api.Publisher;

public class GlarimyLibrary implements Library {
	private static GlarimyLibrary instance;
	private Map<Integer, Book> stock;

	private GlarimyLibrary() {
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

	public static synchronized GlarimyLibrary getInstance() {
		if (instance == null)
			instance = new GlarimyLibrary();
		return instance;
	}

	@Override
	public void add(Book book) throws DuplicateBookException,
			InvalidBookException, LibraryException {
		if (book == null || book.getIsbn() < 1)
			throw new InvalidBookException();
		if (stock.containsKey(book.getIsbn()))
			throw new DuplicateBookException();
		stock.put(book.getIsbn(), book);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		if (stock.containsKey(isbn))
			return stock.get(isbn);
		throw new BookNotFoundException();
	}

	@Override
	public List<Book> list() throws LibraryException {
		return new ArrayList<Book>(stock.values());
	}
}