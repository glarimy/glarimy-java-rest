package com.glarimy.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.glarimy.api.Book;

@Singleton
public class LibraryJpaDao implements LibraryDAO {
	private Map<Integer, Book> books = new HashMap<>();

	public LibraryJpaDao() {
	}

	@Override
	public void create(Book book) {
		books.put(book.getIsbn(), book);

	}

	@Override
	public List<Book> read() {
		return new ArrayList<>(books.values());
	}

	@Override
	public Book read(int isbn) {
		return books.get(isbn);
	}

	@Override
	public boolean isFound(int isbn) {
		if (read(isbn) != null)
			return true;
		return false;
	}
}