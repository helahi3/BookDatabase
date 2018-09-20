package com.springApp.demo.bootstrap;

import com.springApp.demo.model.Author;
import com.springApp.demo.model.Book;
import com.springApp.demo.model.Publisher;
import com.springApp.demo.repositories.AuthorRepository;
import com.springApp.demo.repositories.BookRepository;
import com.springApp.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher penguin = new Publisher("Penguin");
        Publisher hc = new Publisher("Harper Collins");
        publisherRepository.save(penguin);
        publisherRepository.save(hc);

        Author galway = new Author("Tim","Galway");
        Book igot = new Book("Inner Game of Tennis","1234",penguin);
        galway.getBooks().add(igot);
        igot.getAuthors().add(galway);

        authorRepository.save(galway);
        bookRepository.save(igot);


        Author ishiguro = new Author("Kazuo","Ishiguru");
        Book rod = new Book("Remains of the Day","1235",hc);
        ishiguro.getBooks().add(rod);
        rod.getAuthors().add(ishiguro);


        authorRepository.save(ishiguro);
        bookRepository.save(rod);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
