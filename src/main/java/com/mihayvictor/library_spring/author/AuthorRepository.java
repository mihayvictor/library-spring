package com.mihayvictor.library_spring.author;

import com.mihayvictor.library_spring.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {


}
