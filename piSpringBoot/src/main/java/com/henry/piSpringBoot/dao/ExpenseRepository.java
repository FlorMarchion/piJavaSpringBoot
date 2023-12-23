package com.henry.piSpringBoot.dao;





import com.henry.piSpringBoot.entities.Expense;

import java.sql.SQLException;
import java.util.List;

public interface ExpenseRepository {
    Integer insert(Expense expense) throws SQLException;
   /* List<ExpenseDto> getAll();
    void update(ExpenseDto expenseDto);
    void delete(Integer id);*/
}
