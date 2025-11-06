package com.mihayvictor.library_spring.service;

import com.mihayvictor.library_spring.model.dto.request.LoanRequest;
import com.mihayvictor.library_spring.model.entities.Book;
import com.mihayvictor.library_spring.model.entities.Loan;
import com.mihayvictor.library_spring.model.entities.User;
import com.mihayvictor.library_spring.repository.BookRepository;
import com.mihayvictor.library_spring.repository.LoanRepository;
import com.mihayvictor.library_spring.repository.UserRepository;
import com.mihayvictor.library_spring.service.exception.LoanDateException;
import com.mihayvictor.library_spring.service.exception.ObjectNotFoundException;
import com.mihayvictor.library_spring.service.loanPlans.LoanPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LibraryService {
    private double totalDalay;

    @Autowired
    private LoanPlanService loanPlanService;

    @Autowired
    private  LoanService loanService;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanPlanService defaultPlan;


    public Loan processLoan(LoanRequest request){
        loanService.validateLoanDate(request);
        System.out.println("📘 book_id recebido: " + request.getBook_id());
        System.out.println("👤 user_id recebido: " + request.getUser_id());
        System.out.println("📅 loanDate: " + request.getLoanDate());
        Book book = bookRepository.findById(request.getBook_id())
                .orElseThrow(() ->new ObjectNotFoundException("Livro de ID " + request.getBook_id() + " não encontrado."));

        User user = userRepository.findById(request.getUser_id())
                .orElseThrow(() -> new ObjectNotFoundException("Usuário de ID " + request.getUser_id() + " não encontrado."));

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(request.getLoanDate());
        loan.setDays(request.getDays());
        loan.setExpectedReturnDate(request.getLoanDate().plusDays(request.getDays()));
        loan.setRealReturnDate(request.getRealReturnDate());
        loan.setLateDays(request.getLate());
        loan.setDivideByDelay(defaultPlan.calculate(loanService.delay(loan)));
        loan.setLate(loanService.delay(loan));
        return loanRepository.save(loan);
    }
}
