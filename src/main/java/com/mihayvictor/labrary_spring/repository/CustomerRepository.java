package com.mihayvictor.labrary_spring.repository;

import com.mihayvictor.labrary_spring.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
