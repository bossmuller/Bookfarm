package com.apps.bookfarm.Book;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {
    public List<Book> getBooks();

    public void addBook(Book book);


    public  void removeBook(Long id);


    public void updateBook(@RequestBody Book book);
}

