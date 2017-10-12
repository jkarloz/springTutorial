package com.jccz.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jccz.spring5webapp.model.Author;
import com.jccz.spring5webapp.model.Book;
import com.jccz.spring5webapp.repositories.AuthorRepository;
import com.jccz.spring5webapp.repositories.BookRepository;

/**
 * @author Juan Carlos - 2017/10/12
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	private void initData() {
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design","1234", "Harper Collins");
		eric.getBooks().add(ddd);
		
		this.authorRepository.save(eric);
		this.bookRepository.save(ddd);
		
		//Rod
		Author rod =  new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development wihtout EJB", "23444", "Worx");
		rod.getBooks().add(noEJB);
		
		this.authorRepository.save(rod);
		this.bookRepository.save(noEJB);
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
		
	}

}
