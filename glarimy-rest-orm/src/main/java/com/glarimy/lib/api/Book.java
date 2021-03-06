//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.08 at 12:02:51 PM IST 
//

package com.glarimy.lib.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element ref="{http://www.glarimy.com/lib/api}author" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.glarimy.com/lib/api}publisher"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "title", "isbn", "author", "publisher" })
@XmlRootElement(name = "book")
@Entity
public class Book {

	@XmlElement(required = true)
	protected String title;
	@Id
	protected int isbn;
	@XmlElement(required = true)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected List<Author> author;
	@XmlElement(required = true)
	@OneToOne(cascade = CascadeType.ALL)
	protected Publisher publisher;

	/**
	 * Gets the value of the title property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the value of the title property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTitle(String value) {
		this.title = value;
	}

	/**
	 * Gets the value of the isbn property.
	 * 
	 */
	public int getIsbn() {
		return isbn;
	}

	/**
	 * Sets the value of the isbn property.
	 * 
	 */
	public void setIsbn(int value) {
		this.isbn = value;
	}

	/**
	 * Gets the value of the author property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the author property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAuthor().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Author }
	 * 
	 * 
	 */
	public List<Author> getAuthor() {
		if (author == null) {
			author = new ArrayList<Author>();
		}
		return this.author;
	}

	/**
	 * Gets the value of the publisher property.
	 * 
	 * @return possible object is {@link Publisher }
	 * 
	 */
	public Publisher getPublisher() {
		return publisher;
	}

	/**
	 * Sets the value of the publisher property.
	 * 
	 * @param value
	 *            allowed object is {@link Publisher }
	 * 
	 */
	public void setPublisher(Publisher value) {
		this.publisher = value;
	}

}
