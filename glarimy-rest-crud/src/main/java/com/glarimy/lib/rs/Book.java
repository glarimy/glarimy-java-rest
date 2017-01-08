package com.glarimy.lib.rs;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private int isbn;
	private String title;

	public Book() {
		super();
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
