package com.mihayvictor.labrary_spring.service;

import com.mihayvictor.labrary_spring.model.entities.Author;
import com.mihayvictor.labrary_spring.model.entities.Book;
import com.mihayvictor.labrary_spring.model.entities.dto.BookDTO;
import com.mihayvictor.labrary_spring.model.entities.dto.BookRequest;
import com.mihayvictor.labrary_spring.repository.AuthorRepository;
import com.mihayvictor.labrary_spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public Book insert(@RequestBody BookRequest request){
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author não encontrado"));
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPages(request.getPages());
        book.setAuthor(author);
        return bookRepository.save(book);
    }
}
