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
	
	}

}
