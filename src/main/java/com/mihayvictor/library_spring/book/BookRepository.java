package com.mihayvictor.library_spring.book;

import com.mihayvictor.library_spring.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
