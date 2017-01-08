package com.glarimy.db;

import java.util.List;

import com.glarimy.api.Book;

public interface LibraryDAO {
	public void create(Book book);

	public Book read(int isbn);

	public List<Book> read();
	
	public boolean isFound(int isbn);
}
