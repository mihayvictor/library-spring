package com.mihayvictor.library_spring.service.loanPlans;

import com.mihayvictor.library_spring.model.entities.Loan;
import org.springframework.stereotype.Service;

import java.time.Period;

@Service
public class DefaultPlan implements LoanPlanService {
    private double TAX = 2.00;


    @Override
    public double calculate(double delay) {
        return delay * TAX;
    }
}
