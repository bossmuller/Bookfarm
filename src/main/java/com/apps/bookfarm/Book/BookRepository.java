package com.apps.bookfarm.Book;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository  extends JpaRepository<Book, Long> {

    List<Book>findByIsbn(int isbn);

    Optional<Book> findById(Long id);

    //List<Book> findByBookIdOrIsbn(Long id, int isbn);
    void deleteById(Long id);
}
