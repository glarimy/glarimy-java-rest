package com.glarimy.api;

import java.util.List;

public interface Library {
	public void add(Book book) throws InvalidBookException,
			DuplicateBookException, LibraryException;

	public void update(Book book) throws InvalidBookException,
			BookNotFoundException, LibraryException;

	public Book find(int isbn) throws BookNotFoundException, LibraryException;

	public List<Book> search(String title) throws LibraryException;
}
