package com.mihayvictor.library_spring.loan;

import com.mihayvictor.library_spring.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
