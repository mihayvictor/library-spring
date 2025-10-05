package com.mihayvictor.labrary_spring.service;

import com.mihayvictor.labrary_spring.model.entities.Author;
import com.mihayvictor.labrary_spring.model.entities.Book;
import com.mihayvictor.labrary_spring.model.dto.request.BookRequest;
import com.mihayvictor.labrary_spring.repository.AuthorRepository;
import com.mihayvictor.labrary_spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.get();
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

    public void delete(Long id){
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Livro com ID " + id + " Não encontrado."));
            bookRepository.delete(book);
    }

    public void updateData(Book entity, BookRequest obj){
        entity.setTitle(obj.getTitle());
        entity.setPages(obj.getPages());
        Author author = authorRepository.findById(obj.getAuthorId())
                        .orElseThrow(() -> new RuntimeException("Autor com ID " + obj.getAuthorId() + " Não encontrado."));
        entity.setAuthor(author);
    }

    public Book update(Long id, BookRequest obj){
        try {
            Book entity = bookRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Livro com ID " + id + " Não encontrado."));
            updateData(entity, obj);
            return bookRepository.save(entity);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
