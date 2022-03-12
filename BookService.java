package com.greatlearning.lmsapp;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BookService {

	public List<Book> findAll();
	
	public List<Book> searchBy(String name, String author);
	
	public Book findById(int id);
	
	public void save(Book book); // save or update
	
	public void deleteById(int id);
}

