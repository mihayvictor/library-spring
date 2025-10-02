package com.mihayvictor.labrary_spring.controller;

import com.mihayvictor.labrary_spring.model.entities.Book;
import com.mihayvictor.labrary_spring.model.entities.dto.BookDTO;
import com.mihayvictor.labrary_spring.model.entities.dto.BookRequest;
import com.mihayvictor.labrary_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>>findAll(){
        List<Book>list = bookService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<BookDTO>Insert(@RequestBody BookRequest bookRequest) {

        Book createdBook = bookService.insert(bookRequest);

        BookDTO bookDTO = new BookDTO(createdBook);

        return ResponseEntity.status(201).body(bookDTO);

    }

}
