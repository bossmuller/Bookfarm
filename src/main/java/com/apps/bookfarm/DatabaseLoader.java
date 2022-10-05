package com.apps.bookfarm;


import com.apps.bookfarm.Author.Author;
import com.apps.bookfarm.Author.AuthorRepository;
import com.apps.bookfarm.Book.Book;
import com.apps.bookfarm.Book.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseLoader {
    public static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);
    @Bean
    CommandLineRunner initDatabase(AuthorRepository authorRepository, BookRepository bookRepository){
        return args -> {
            Author authorOne = new Author();
            authorOne.setAuthorName("Boss yln");
            authorOne.setPhoneNumber(254678);
            Author authorTwo = new Author("Emily Jefferson",2548765);
            // save new author
            authorRepository.save(new Author("Wallace Kim", 254364));
            authorRepository.save(new Author("George Kim", 254567));
            authorRepository.save(new Author("Alphonso Kim", 254345));
            authorRepository.save(new Author("Kardashia Kim", 254453));


            authorRepository.save(authorOne);
            authorRepository.save(authorTwo);

           // bookRepository.save(new Book("Art of CS",1,"Mc Milan",342323,200,"cs"));

            //Log the author entry
            authorRepository.findAll().forEach(author -> log.info("Preloaded Author:" + author));

            Book bookOne= new Book();
            bookOne.setTitle("Programming");
            bookOne.setAuthor(authorOne);
            bookOne.setPublisher("Mac Milan");
            bookOne.setIsbn(233343);
            bookOne.setLength(234);
            bookOne.setSubject("Coding,IT");

            Book bookTwo= new Book();
            bookTwo.setTitle("Communication Skills");
            bookTwo.setAuthor(authorTwo);
            bookTwo.setPublisher("Shakes spear");
            bookTwo.setIsbn(233343);
            bookTwo.setLength(234);
            bookTwo.setSubject("Reading skill,Book review");

            bookRepository.save(new Book("Pusdd", authorTwo,"Mac Milan",21231,254,"FDFE,ERER"));

            bookRepository.save(bookOne);

            bookRepository.save(bookTwo);

            //Log the book entry
            bookRepository.findAll().forEach(book -> log.info("Preloads Book: " + book));



        };
    }
}
