package com.greatlearning.lmsapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		
		List<Book> books = bookService.findAll();
		theModel.addAttribute("books",books);
		return "list-books"; // /WEB-INF/views/list-books.jsp
		
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormforAdd(Model theModel) {
		Book theBook = new Book();
		
		theModel.addAttribute("Book",theBook);
		
		return "Book-form";
		
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormforUpdate(@RequestParam("bookId") int id,Model theModel) {
		Book theBook = bookService.findById(id);
		
		theModel.addAttribute("Book",theBook);
		
		return "Book-form";
		
	}
	
	
	
	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id,
			@RequestParam("name") String name,@RequestParam("category") String category,@RequestParam("author") String author) {
	
		System.out.println(id);
		
	Book theBook;
	
	if(id!=0) {
		theBook  = bookService.findById(id);
		theBook.setName(name);
		theBook.setCategory(category);
		theBook.setAuthor(author);
	}
	else
		theBook = new Book(name,category,author);
	bookService.save(theBook);
	
	return "redirect:/books/list";
	
}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("bookId") int theId) {

		// delete the Book
		bookService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/books/list";

	}
}
