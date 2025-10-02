package com.mihayvictor.labrary_spring.repository;

import com.mihayvictor.labrary_spring.model.entities.Author;
import com.mihayvictor.labrary_spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {


}
