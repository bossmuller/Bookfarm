package com.apps.bookfarm.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController{
    private final AuthorRepository authorRepository;
    private final AuthorServiceImpl authorService;
    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorServiceImpl authorService) {

        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    List<Author> allAuthors(){

        return authorService.getAuthors();
    }
    @GetMapping("/authors/{id}")
    Author oneAuthor(@PathVariable Long id){
        return authorRepository.findById(id).orElseThrow(()->new AuthorNotFoundException(id));

    }
    @GetMapping("/authors/contacts/{phone}")
    List<Author>authorPhone(@PathVariable int phone){

        return authorRepository.findByPhoneNumber(phone);
    }
    @PostMapping("/authors")
    void addNewAuthor(@RequestBody Author newAuthor){

        authorService.addNewAuthor(newAuthor);
    }
    @PutMapping("/authors/{id}")
    Author replaceAuthor(@RequestBody Author newAuthor ,@PathVariable Long id){
        return authorRepository.findById(id).map(Author  -> {
            Author.setAuthorName(newAuthor.getAuthorName());
            Author.setPhoneNumber(newAuthor.getPhoneNumber());
            return authorRepository.save(newAuthor);
        }).orElseGet(()->{
            newAuthor.setAuthorId(id);
            return authorRepository.save(newAuthor);
        });
    }



    @DeleteMapping("/authors/{id}")
    void deleteAuthor(@PathVariable Long id){
        authorRepository.deleteById(id);
    }
}
