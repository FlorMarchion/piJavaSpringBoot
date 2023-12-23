package com.henry.piSpringBoot.service;

import com.henry.piSpringBoot.request.ExpenseRequestDto;

import java.sql.SQLException;

public interface ExpenseService {
    String createExpense(ExpenseRequestDto expenseRequestDto) throws SQLException;
}
