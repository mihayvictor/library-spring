package com.mihayvictor.labrary_spring.controller;

import com.mihayvictor.labrary_spring.model.entities.Author;
import com.mihayvictor.labrary_spring.model.entities.Book;
import com.mihayvictor.labrary_spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

   @Autowired
   private AuthorService service;

    @GetMapping
    public ResponseEntity<List<Author>> findAll(){
        List<Author>list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Author>Insert(@RequestBody Author author){
        author = service.insert(author);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{authors}").
                buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(author);
    }
}
