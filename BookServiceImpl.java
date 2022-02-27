package com.greatlearning.lmsapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookServiceImpl implements BookService {
	
	
	private SessionFactory sessionFactory;
	private Session session;
	
	
	public BookServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = this.sessionFactory.openSession();
	}

	public List<Book> findAll() {
		Transaction tx = session.beginTransaction();
		
		// from EntityName
		List<Book> books = session.createQuery("from Book",Book.class).list();
		
		tx.commit();
		
		return books;
	}

	public List<Book> searchBy(String name, String author) {
		// TODO Auto-generated method stub
		return null;
	}

	public Book findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Book book) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
		

}
