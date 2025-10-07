package com.mihayvictor.library_spring.repository;

import com.mihayvictor.library_spring.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {


}
