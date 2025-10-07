package com.mihayvictor.library_spring.repository;

import com.mihayvictor.library_spring.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
