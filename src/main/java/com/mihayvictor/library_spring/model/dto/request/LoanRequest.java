package com.mihayvictor.library_spring.model.dto.request;

import com.mihayvictor.library_spring.model.entities.Loan;

import java.time.LocalDate;
import java.time.Period;

public class LoanRequest {
    private LocalDate loanDate;
    private LocalDate expectedReturnDate;
    private LocalDate realReturnDate;
    private int late;
    private int days;
    private Long user_id;
    private Long book_id;

    public LoanRequest() {
    }

    public LoanRequest(LocalDate loanDate, int days, LocalDate realReturnDate, Long user_id, Long book_id) {
        this.loanDate = loanDate;
        expectedReturnDate = loanDate.plusDays(days);
        this.realReturnDate = realReturnDate;
        late = daysLate();
        this.user_id = user_id;
        this.book_id = book_id;
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

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }


    public int getLatedays() {
        return late;
    }

    public void setLatedays(int late) {
        this.late = late;
    }

    public int loanDays(){
        Period period = Period.between(this.getLoanDate(), this.getExpectedReturnDate());
        int yearLate = period.getYears();
        int monthsLate = period.getMonths();
        int daysLate = period.getDays();
        return yearLate * 365 + monthsLate * 30 + daysLate;
    }

    public int daysLate(){
        Period period = Period.between(getExpectedReturnDate(), getRealReturnDate());
        int yearLate = period.getYears();
        int monthsLate = period.getMonths();
        int daysLate = period.getDays();
        return yearLate * 365 + monthsLate * 30 + daysLate;
    }
}
