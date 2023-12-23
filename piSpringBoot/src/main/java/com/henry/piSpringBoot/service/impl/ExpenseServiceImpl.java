package com.henry.piSpringBoot.service.impl;


import com.henry.piSpringBoot.dao.ExpenseRepository;
import com.henry.piSpringBoot.entities.Expense;
import com.henry.piSpringBoot.request.ExpenseRequestDto;
import com.henry.piSpringBoot.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public String createExpense(ExpenseRequestDto expenseRequestDto) throws SQLException {
        String response = "El gasto ha sido registrado con éxito !";

        Expense expense = mapDtoToExpense(expenseRequestDto);
        Integer responseInserted = expenseRepository.insert(expense);
        if(responseInserted.equals(0)){
            System.out.println("No se insertó ningún registro");
        }
        return response;
    }

    private Expense mapDtoToExpense(ExpenseRequestDto expenseRequestDto) {
        Expense expense = new Expense();
        expense.setDate(expenseRequestDto.getDate());
        expense.setDescription(expenseRequestDto.getDescription());
        expense.setAmount(expenseRequestDto.getAmount());
        expense.setCategoryName(expenseRequestDto.getCategoryRequestDto().getName());
        return expense;
    }


}
