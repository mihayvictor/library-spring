package com.mihayvictor.library_spring.service;

import com.mihayvictor.library_spring.model.dto.request.LoanRequest;
import com.mihayvictor.library_spring.model.entities.Loan;
import com.mihayvictor.library_spring.repository.LoanRepository;
import com.mihayvictor.library_spring.service.exception.LoanDateException;
import com.mihayvictor.library_spring.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    public List<Loan>findAll(){
      return repository.findAll();
    }

    public Loan findById(Long id){
        Optional<Loan> obj = Optional.ofNullable(repository.findById(id))
                .orElseThrow(() -> new ObjectNotFoundException("ID não encontrado."));
        return obj.get();
    }

    protected void validateLoanDate(LoanRequest request){
        if (request.getRealReturnDate().isBefore(request.getLoanDate())){
            throw new LoanDateException("A data de devolução não pode ser anterior a data de emprestímo.");
        }
    }

    public int delay(Loan loan){
        Period period = Period.between(loan.getExpectedReturnDate(), loan.getRealReturnDate());
        int yearsLate = period.getYears();
        int monthsLate = period.getMonths();
        int daysLate = period.getDays();
        return yearsLate * 365 + monthsLate * 30 + daysLate;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
