package com.henry.piSpringBoot.interfaces;


import com.henry.piSpringBoot.dao.dto.ExpenseDto;
import com.henry.piSpringBoot.entities.Expense;

import java.util.List;

public interface ExpenseCalculator {

    //Firmas del método
    double calculateExpense(Expense expense);
    double calculateTotalExpense(List<ExpenseDto> expenses); //Lista que almacena todos los gastos
}
