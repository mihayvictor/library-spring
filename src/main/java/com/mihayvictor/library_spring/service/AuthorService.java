package com.mihayvictor.library_spring.service;

import com.mihayvictor.library_spring.model.entities.Author;
import com.mihayvictor.library_spring.repository.AuthorRepository;
import com.mihayvictor.library_spring.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> findAll(){
        return repository.findAll();
    }

    public Author findById(Long id){
        Optional<Author> obj = Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Author não encontrado")));;
        return obj.get();
    }

    public Author insert(Author author){
        return repository.save(author);
    }

    public void delete(Long id){
        try {
            Author author = repository.findById(id)
                    .orElseThrow(() -> new ObjectNotFoundException("Autor de ID " + id + " não encontrado"));
            repository.delete(author);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    public Author update(Long id, Author author){
        Optional<Author> obj = Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Author não encontrado")));
        Author authorObj = obj.get();
        authorObj.setName(author.getName());
        return repository.save(authorObj);
    }
}
