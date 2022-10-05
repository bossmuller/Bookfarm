package com.apps.bookfarm.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AuthorServiceImpl implements AuthorServices{

    private final AuthorRepository authorRepository;

    @Autowired

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();

    }

    @Override
    public void addNewAuthor(Author author) {
        List<Author>optionalAuthor = authorRepository.findByPhoneNumber(author.getPhoneNumber());
        if (!optionalAuthor.isEmpty()){
            throw new IllegalStateException("Author already Exists");
        }
        authorRepository.save(author);

    }

    @Override
    public void removeAuthor(Long id) {

    }
}
