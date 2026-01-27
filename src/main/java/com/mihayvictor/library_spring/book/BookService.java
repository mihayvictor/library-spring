package com.mihayvictor.library_spring.book;

import com.mihayvictor.library_spring.author.entity.Author;
import com.mihayvictor.library_spring.author.AuthorRepository;
import com.mihayvictor.library_spring.book.dto.BookRequest;
import com.mihayvictor.library_spring.book.entity.Book;
import com.mihayvictor.library_spring.exception.serviceException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Optional<Book> obj = Optional.of(bookRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Livro com o ID " + id + " Não encontrado.")));
        return obj.get();
    }

    public Book insert( BookRequest request){
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new ObjectNotFoundException("Author com o ID " + request.getAuthorId() + " não encontrado"));
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPages(request.getPages());
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public void delete(Long id){
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new ObjectNotFoundException("Livro com o ID " + id + " Não encontrado."));
            bookRepository.delete(book);
    }

    public void updateData(Book entity, BookRequest obj){
        entity.setTitle(obj.getTitle());
        entity.setPages(obj.getPages());
        Author author = authorRepository.findById(obj.getAuthorId())
                        .orElseThrow(() -> new ObjectNotFoundException("Autor com o ID " + obj.getAuthorId() + " Não encontrado."));
        entity.setAuthor(author);
    }

    public Book update(Long id, BookRequest obj){
            Book entity = bookRepository.findById(id)
                    .orElseThrow(() -> new ObjectNotFoundException("Livro com o ID " + id + " Não encontrado."));
            updateData(entity, obj);
            return bookRepository.save(entity);
    }
}
