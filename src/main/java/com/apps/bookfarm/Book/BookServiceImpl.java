package com.apps.bookfarm.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    @Autowired

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        List<Book> optionalBook = bookRepository.findByIsbn(book.getIsbn());
        if (!optionalBook.isEmpty()){
            throw new IllegalStateException("The book already exist");
        }
        bookRepository.save(book);
    }


    @Override
    public void removeBook(Long id) {
        Optional<Book> bookToDelete = bookRepository.findById(id);
      if (bookToDelete.isEmpty()) {
           throw new IllegalStateException("The book does not exist");           }
         bookRepository.deleteById(id);
}

    @Override
    public void updateBook(Book book) {


    }


}
