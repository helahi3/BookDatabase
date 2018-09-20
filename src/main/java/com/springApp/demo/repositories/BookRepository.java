package com.springApp.demo.repositories;

import com.springApp.demo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
