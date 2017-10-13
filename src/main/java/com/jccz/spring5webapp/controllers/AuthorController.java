package com.jccz.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jccz.spring5webapp.repositories.AuthorRepository;

/**
 * @author Juan Carlos - 2017/10/13
 *
 */
@Controller
public class AuthorController {
	private AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "authors";
	}

}
