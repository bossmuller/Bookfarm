package com.apps.bookfarm.Author;

import java.util.List;

public interface AuthorServices {
    public List<Author> getAuthors();
    public void  addNewAuthor(Author author);
    public void removeAuthor(Long id);
}
