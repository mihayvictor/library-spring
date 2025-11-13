package com.mihayvictor.library_spring.model.dto.response;

import com.mihayvictor.library_spring.model.entities.Book;
import com.mihayvictor.library_spring.model.entities.Loan;
import com.mihayvictor.library_spring.model.entities.User;

import java.time.LocalDate;

public class LoanResponse {

    private Long id;
    private LocalDate loanDate;
    private LocalDate expectedReturnDate;
    private LocalDate realReturnDate;
    private int lateDays;
    private Double divideByDelay;

    private BookResponse bookResponse;
    private User user;

    public LoanResponse(){
    }

    public LoanResponse toResponse(Loan loan){
        LoanResponse response = new LoanResponse();
        response.setId(loan.getId());
        response.setLoanDate(loan.getLoanDate());
        response.setExpectedReturnDate(loan.getExpectedReturnDate());
        response.setRealReturnDate(loan.getRealReturnDate());
        response.setDivideByDelay(loan.getDivideByDelay());
        response.setBookResponse(new BookResponse(loan.getBook()));
        response.setUser(loan.getUser());
        response.setLateDays(loan.getLate());
        return response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getRealReturnDate() {
        return realReturnDate;
    }

    public void setRealReturnDate(LocalDate realReturnDate) {
        this.realReturnDate = realReturnDate;
    }

    public Double getDivideByDelay() {
        return divideByDelay;
    }

    public void setDivideByDelay(Double divideByDelay) {
        this.divideByDelay = divideByDelay;
    }

    public int getLateDays() {
        return lateDays;
    }

    public void setLateDays(int lateDays) {
        this.lateDays = lateDays;
    }

    public BookResponse getBookResponse() {
        return bookResponse;
    }

    public void setBookResponse(BookResponse bookResponse) {
        this.bookResponse= bookResponse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
