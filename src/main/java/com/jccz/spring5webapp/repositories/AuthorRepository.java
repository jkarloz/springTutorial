package com.jccz.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jccz.spring5webapp.model.Author;

/**
 * @author Juan Carlos - 2017/10/11
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
