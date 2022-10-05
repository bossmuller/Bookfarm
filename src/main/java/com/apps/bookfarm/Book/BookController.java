package com.apps.bookfarm.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController{
    private final BookRepository bookRepository;
    private final BookService bookService;


    @Autowired
    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;

        this.bookService = bookService;
    }
    @GetMapping("/books")
    List<Book> allbooks() {

        return bookService.getBooks();
    }
    @GetMapping("/books/{id}")
    Book oneBook(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
    }
    @GetMapping ("/books/isbn/{isbn}")
    List<Book> bookIsbn( @PathVariable int isbn){
        return bookRepository.findByIsbn(isbn);
    }
    @PostMapping("/books")
   void newBook(@RequestBody Book newBook){
        bookService.addBook(newBook);
    }
    @PutMapping("/books/{id}")
    void replaceBook(@RequestBody Book newBook, @PathVariable Long id){
          bookRepository.findById(id).map(Book->{
            Book.setAuthor(newBook.getAuthor());
            Book.setTitle(newBook.getTitle());
            Book.setPublisher(newBook.getPublisher());
            Book.setSubject(newBook.getSubject());
            Book.setIsbn(newBook.getIsbn());
            Book.setLength(newBook.getLength());


            bookService.updateBook(newBook);

            return bookRepository.save(newBook);
          }).orElseGet(()->{
            newBook.setBookId(id);
            return bookRepository.save(newBook);
        });

    }
    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
    }
}
