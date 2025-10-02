package com.mihayvictor.labrary_spring.repository;

import com.mihayvictor.labrary_spring.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
