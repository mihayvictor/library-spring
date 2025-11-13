package com.mihayvictor.library_spring.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(optional = false)
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate loanDate;
    private int days;
    private LocalDate expectedReturnDate;
    private LocalDate realReturnDate;
    private int late;
    private double divideByDelay;

    public Loan() {
    }

    public Loan(Long id, Book book, User user, LocalDate loanDate, int days) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
        this.days = days;
        expectedReturnDate = loanDate.plusDays(days);
        late = daysLate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getLateDays() {
        return late;
    }

    public void setLateDays(int late) {
        this.late = late;
    }

    public Double getDivideByDelay() {
        return divideByDelay;
    }

    public void setDivideByDelay(Double divideByDelay) {
        this.divideByDelay = divideByDelay;
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

    public void setDivideByDelay(double divideByDelay) {
        this.divideByDelay = divideByDelay;
    }

    public int daysLate(){
        Period period = Period.between(getExpectedReturnDate(), getRealReturnDate());
        int yearLate = period.getYears();
        int monthsLate = period.getMonths();
        int daysLate = period.getDays();
        return yearLate * 365 + monthsLate * 30 + daysLate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", loanDate=" + loanDate +
                ", days=" + days +
                ", expectedReturnDate=" + expectedReturnDate +
                ", realReturnDate=" + realReturnDate +
                ", late=" + late +
                ", divideByDelay=" + divideByDelay +
                '}';
    }
}
