package com.jccz.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jccz.spring5webapp.model.Publisher;

/**
 * @author Juan Carlos - 2017/10/12
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
