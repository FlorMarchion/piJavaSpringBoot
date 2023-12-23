package com.henry.piSpringBoot.interfaces;


import com.henry.piSpringBoot.exceptions.InvalidExpenseException;

@FunctionalInterface
public interface ExpenseAmountValidator {
    boolean validateAmount(double amount) throws InvalidExpenseException;
}
