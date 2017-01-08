package com.glarimy.lib.api;

import java.util.List;

public interface Library {
	public void add(Book book) throws DuplicateBookException,
			InvalidBookException, LibraryException;

	public Book find(int isbn) throws BookNotFoundException, LibraryException;

	public List<Book> list() throws LibraryException;
}
