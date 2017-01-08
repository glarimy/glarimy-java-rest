package com.glarimy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glarimy.api.Book;
import com.glarimy.api.BookNotFoundException;
import com.glarimy.api.DuplicateBookException;
import com.glarimy.api.InvalidBookException;
import com.glarimy.api.Library;
import com.glarimy.api.LibraryException;
import com.glarimy.db.LibraryDAO;

@Service
public class SimpleLibrary implements Library {
	@Autowired
	LibraryDAO dao;

	@Override
	public void add(Book book) throws InvalidBookException,
			DuplicateBookException, LibraryException {
		System.out.println("Adding the book");
		if (book == null || book.getIsbn() < 1 || book.getTitle() == null
				|| book.getTitle().trim().length() == 0)
			throw new InvalidBookException();
		if (dao.isFound(book.getIsbn()))
			throw new DuplicateBookException();
		dao.create(book);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		Book book = dao.read(isbn);
		if (book == null)
			throw new BookNotFoundException();
		return book;
	}

	@Override
	public List<Book> search(String title) throws LibraryException {
		List<Book> list = new ArrayList<>();
		for (Book book : dao.read()) {
			if (book.getTitle().contains(title))
				list.add(book);
		}
		return list;
	}

	@Override
	public void update(Book book) throws InvalidBookException,
			BookNotFoundException, LibraryException {
		if (book == null || book.getIsbn() < 1 || book.getTitle() == null
				|| book.getTitle().trim().length() == 0)
			throw new InvalidBookException();
		if (!dao.isFound(book.getIsbn()))
			throw new BookNotFoundException();
		dao.create(book);
	}
}
