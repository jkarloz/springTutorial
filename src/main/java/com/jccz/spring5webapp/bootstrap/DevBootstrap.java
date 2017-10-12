package com.jccz.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jccz.spring5webapp.model.Author;
import com.jccz.spring5webapp.model.Book;
import com.jccz.spring5webapp.model.Publisher;
import com.jccz.spring5webapp.repositories.AuthorRepository;
import com.jccz.spring5webapp.repositories.BookRepository;
import com.jccz.spring5webapp.repositories.PublisherRepository;

/**
 * @author Juan Carlos - 2017/10/12
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	private void initData() {
		//Eric
		Author eric = new Author("Eric", "Evans");
		Publisher publisher1 = new Publisher("Harper Collins", "address for Harper");
		Book ddd = new Book("Domain Driven Design","1234", publisher1);
		eric.getBooks().add(ddd);
		
		this.publisherRepository.save(publisher1);
		this.authorRepository.save(eric);
		this.bookRepository.save(ddd);

		
		//Rod
		Author rod =  new Author("Rod", "Johnson");
		Publisher publisher2 = new Publisher("Worxs", "address for Worx");
		Book noEJB = new Book("J2EE Development wihtout EJB", "23444", publisher2);
		rod.getBooks().add(noEJB);
		
		this.publisherRepository.save(publisher2);
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
