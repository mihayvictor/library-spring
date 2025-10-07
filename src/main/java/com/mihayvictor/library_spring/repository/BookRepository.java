package com.mihayvictor.library_spring.repository;

import com.mihayvictor.library_spring.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
