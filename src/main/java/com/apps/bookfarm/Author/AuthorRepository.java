package com.apps.bookfarm.Author;
import com.apps.bookfarm.Author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository <Author,Long> {
    Optional<Author> findByAuthorName(String name);
    List<Author> findByPhoneNumber(int PhoneNumber);
}
