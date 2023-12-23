package com.henry.piSpringBoot.dao;


import com.henry.piSpringBoot.dao.dto.ExpenseCategoryDto;
import com.henry.piSpringBoot.entities.ExpenseCategory;

public interface ExpenseCategoryDao {
    void insert(ExpenseCategoryDto expense);
    ExpenseCategory getCategoryName(String name);
}
