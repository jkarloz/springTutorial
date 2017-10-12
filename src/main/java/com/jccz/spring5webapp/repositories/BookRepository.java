package com.jccz.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jccz.spring5webapp.model.Book;

/**
 * @author Juan Carlos - 2017/10/12
 *
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
