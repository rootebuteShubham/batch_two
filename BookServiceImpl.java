package com.greatlearning.lmsapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class BookServiceImpl implements BookService {
	
	
	private SessionFactory sessionFactory;
	private Session session;
	
	
	public BookServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = this.sessionFactory.openSession();
	}

	public List<Book> findAll() {
		
		Transaction tx = session.beginTransaction();
		
		// from "EntityName"
		List<Book> books = session.createQuery("from Book", Book.class).list();
		
		tx.commit();
		
		return books;
	}

	public List<Book> searchBy(String name, String author) {
		
		Transaction tx = session.beginTransaction();
		
		String query = "";
		
		if(name.length() != 0 && author.length() != 0) {
			query = "from Book where name like '%" + name + "%' or author like '%" + author + "%'";
		} else if(name.length() != 0) {
			query = "from Book where name like '%" + name + "%'";
		} else if(author.length() != 0) {
			query = "from Book where author like '%" + author + "%'";
		} else {
			System.out.println("No records");
		}
		
		List<Book> books = session.createQuery(query,Book.class).list();
		tx.commit();
		
		return books;
	}

	public Book findById(int id) {
		Transaction tx = session.beginTransaction();
		Book book = session.get(Book.class,id);
		
		tx.commit();
		return book;
	}

	public void save(Book book) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(book);
		tx.commit();
	}

	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();
		
		try {
		Book book = session.get(Book.class, id);
		session.delete(book);
		} finally {
			tx.commit();
		}
		
	}

}
