package hh.palvelinohjelmointi.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String title;
	private String author;
	private int year;
	private int isbn;
	
	//konstruktorit
	
	public Book(){
		super();
		this.id = null;
		this.title = null;
		this.author= null;
		this.year = 0;
		this.isbn = 0;
		
	}
	
	public Book(String title, String author, int year, int isbn) {
		super();
		this.title  =title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
	}
	public Book(Long id, String title, String author, int year, int isbn) {
		super();
		this.id = id;
		this.title  =title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setPrice(Long id) {
		this.id = id;
	}
	
}
