package com.mihayvictor.library_spring.loan;

import com.mihayvictor.library_spring.book.entity.Book;
import com.mihayvictor.library_spring.client.entity.User;
import com.mihayvictor.library_spring.book.BookRepository;
import com.mihayvictor.library_spring.client.UserRepository;
import com.mihayvictor.library_spring.exception.serviceException.LoanDateException;
import com.mihayvictor.library_spring.exception.serviceException.ObjectNotFoundException;
import com.mihayvictor.library_spring.loan.dto.LoanRequest;
import com.mihayvictor.library_spring.loan.entity.Loan;
import com.mihayvictor.library_spring.loan.loanPlans.LoanPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LibraryLoanService {
    private double totalDalay;

    @Autowired
    private LoanPlanService loanPlanService;

    @Autowired
    private LoanService loanService;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanPlanService defaultPlan;


    public Loan processLoan(LoanRequest request){

        if(request.getDays() < 1) {
            throw new LoanDateException
                    ("A quantidade de dias para o emprestímo de livros não podem ser menor que 1.");
        };

        loanService.validateLoanDate(request);
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

        user.addLoan(loan);
        return loanRepository.save(loan);
    }
}
