package com.glarimy.lib.api;

public interface Library {
	public void add(Book book) throws DuplicateBookException,
			InvalidBookException, LibraryException;

	public Book find(int isbn) throws BookNotFoundException, LibraryException;
}
