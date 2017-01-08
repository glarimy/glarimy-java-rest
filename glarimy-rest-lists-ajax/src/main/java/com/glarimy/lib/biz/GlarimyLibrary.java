package com.glarimy.lib.biz;

import java.util.List;

import com.glarimy.lib.api.Book;
import com.glarimy.lib.api.BookNotFoundException;
import com.glarimy.lib.api.DuplicateBookException;
import com.glarimy.lib.api.InvalidBookException;
import com.glarimy.lib.api.Library;
import com.glarimy.lib.api.LibraryException;

public class GlarimyLibrary implements Library {
	private BookDAO dao = BookDAO.getInstance();

	@Override
	public void add(Book book) throws DuplicateBookException,
			InvalidBookException, LibraryException {
		if (book == null || book.getIsbn() < 1)
			throw new InvalidBookException();
		if (dao.read(book.getIsbn()) != null)
			throw new DuplicateBookException();
		dao.create(book);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		if (dao.read(isbn) == null)
			throw new BookNotFoundException();
		return dao.read(isbn);
	}

	@Override
	public List<Book> list() throws LibraryException {
		return dao.read();
	}
}