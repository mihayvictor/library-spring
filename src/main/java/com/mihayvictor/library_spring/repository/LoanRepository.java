package com.mihayvictor.library_spring.repository;

import com.mihayvictor.library_spring.model.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
