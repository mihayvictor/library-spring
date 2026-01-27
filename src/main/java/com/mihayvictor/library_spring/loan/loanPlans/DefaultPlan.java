package com.mihayvictor.library_spring.loan.loanPlans;

import org.springframework.stereotype.Service;

@Service
public class DefaultPlan implements LoanPlanService {
    private double TAX = 2.00;


    @Override
    public double calculate(double delay) {
        return delay * TAX;
    }
}
