package com.jccz.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jccz.spring5webapp.repositories.BookRepository;

/**
 * @author Juan Carlos - 2017/10/12
 *
 */
@Controller
public class BookController {
	
	private BookRepository bookRepository;	
	
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books"; // will be associated by Spring to a view with that name
	}

}
