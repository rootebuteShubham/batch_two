package com.greatlearning.lmsapp;

import java.util.List;

public interface BookService {
	
	public List<Book> findAll();
	
	public List<Book> searchBy(String name, String author);
	
	public Book findById(int id);
	
	public void save(Book book); // save (insert) or update
	
	public void deleteById(int id);

}
