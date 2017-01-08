package com.glarimy.lib.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.glarimy.lib.api.Author;
import com.glarimy.lib.api.Book;
import com.glarimy.lib.api.Publisher;

public class BookDAO {
	private static SessionFactory factory;
	private static BookDAO instance;

	private BookDAO() {
		Configuration conf = new Configuration();
		conf.configure();
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
				conf.getProperties()).buildServiceRegistry();
		factory = conf.buildSessionFactory(registry);

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

		Session session = factory.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();
	}

	public static synchronized BookDAO getInstance() {
		if (instance == null)
			instance = new BookDAO();
		return instance;
	}

	public void create(Book book) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();
	}

	public Book read(int isbn) {
		Session session = factory.openSession();
		Book contact = (Book) session.get(Book.class, isbn);
		session.close();
		return contact;
	}

	public List<Book> read() {
		Session session = factory.openSession();
		List<Book> books = session.createQuery("from " + Book.class.getName())
				.list();
		session.close();
		return books;
	}
}
