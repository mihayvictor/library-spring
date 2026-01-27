package com.mihayvictor.library_spring.client;

import com.mihayvictor.library_spring.client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
