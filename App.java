package com.greatlearning.lmsapp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class);
		
		SessionFactory sessionFactory = con.buildSessionFactory();
		
		
		BookService bookService = new BookServiceImpl(sessionFactory);

		List<Book> books = bookService.findAll();
		
		
		for(Book book : books) {
			System.out.println(book);
		}
		
		
		// findById
		Book book = bookService.findById(2);
		System.out.println(book);
		
		// Create or Insert
		
		Book newBook = new Book("Redux","Programming","Dan Abramov");
		bookService.save(newBook);
		
		//Update
		book.setAuthor("H&C");
		bookService.save(book);
		
		// Delete
		
		try {
		bookService.deleteById(4);
		} catch (Exception e) {
			System.out.println("The book does not exist");
		}
		
		
		List<Book> matchedBooks = bookService.searchBy("Java", "");
		
		for(Book b : matchedBooks) {
			System.out.println(b);
		}
	}

}
