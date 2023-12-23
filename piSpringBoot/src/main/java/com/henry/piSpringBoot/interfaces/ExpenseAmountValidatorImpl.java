package com.henry.piSpringBoot.interfaces;


import com.henry.piSpringBoot.exceptions.InvalidExpenseException;

public class ExpenseAmountValidatorImpl implements ExpenseAmountValidator {

    //Método que valida el monto
    @Override
    public boolean validateAmount(double amount) throws InvalidExpenseException {
        if(amount < 0){
            throw new InvalidExpenseException("El monto debe ser igual o mayor a cero");
        }
        return false;
    }
}
