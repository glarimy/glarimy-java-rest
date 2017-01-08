package com.glarimy.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.glarimy.api.Book;

@Repository
public class LibraryJpaDao implements LibraryDAO {
	@PersistenceContext(unitName = "lib")
	private EntityManager em;

	public LibraryJpaDao() {
		System.out.println("************** dao constructed *****************");
	}

	@Override
	public void create(Book book) {
		System.out.println("Persisting the book");
		em.persist(book);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> read() {
		return em.createQuery("from " + Book.class).getResultList();
	}

	@Override
	public Book read(int isbn) {
		return em.find(Book.class, isbn);
	}

	@Override
	public boolean isFound(int isbn) {
		if (em.find(Book.class, isbn) != null)
			return true;
		return false;

	}
}