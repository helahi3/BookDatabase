package com.springApp.demo.repositories;

import com.springApp.demo.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
