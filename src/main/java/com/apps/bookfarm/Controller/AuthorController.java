package com.apps.bookfarm.Controller;

import com.apps.bookfarm.Model.Author;
import com.apps.bookfarm.Repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthorController{
    private final AuthorRepository authorRepository;


    public AuthorController(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }
    @GetMapping("/authors")
    Iterable<Author>allAuthors(){

        return authorRepository.findAll();
    }
    @GetMapping("/authors/{Id}")
    Optional<Author> oneAuthor(@PathVariable Long Id){
        return authorRepository.findById(Id);

    }
    @PostMapping("/authors")
    Author newAuthor(@RequestBody Author newAuthor){
        return authorRepository.save(newAuthor);
    }
    //@PutMapping("/authors/{Id}")
   // Author replaceAuthor(@RequestBody Author newAuthor,@PathVariable Long Id){
      //  return authorRepository.findById(Id).map() -> {
           // newAuthor.setAuthorName(newAuthor.getAuthorName());
            //newAuthor.setPhoneNumber(newAuthor.getPhoneNumber());
            //return authorRepository.save(newAuthor);
       // }
   // }
}
