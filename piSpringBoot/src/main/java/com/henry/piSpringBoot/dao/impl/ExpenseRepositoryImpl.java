package com.henry.piSpringBoot.dao.impl;

import com.henry.piSpringBoot.dao.ExpenseRepository;
import com.henry.piSpringBoot.dao.dto.ExpenseDto;
import com.henry.piSpringBoot.entities.Expense;
import com.henry.piSpringBoot.entities.ExpenseCategory;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;


@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private static final String GET_ALL_EXPENSES = "SELECT * FROM Expense";
    private static final String INSERT_INTO_CATEGORY_EXPENSE = "INSERT INTO ExpenseCategory (name) VALUES (?)";

    private static final String SELECT_FROM_EXPENSE_CATEGORY_BY_NAME = "SELECT * FROM ExpenseCategory WHERE name = ?";
    private static final String INSERT_INTO_EXPENSE = "INSERT INTO Expense(date, description, amount, categoryId, categoryName) VALUES (?, ?, ?, ?, ?)";
    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Expense mapDtoToExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setDate(expenseDto.getDate());
        expense.setAmount(expenseDto.getAmount());
        expense.setCategoryId(expenseDto.getCategoryId());
        expense.setCategoryName(expenseDto.getCategoryName());
        return expense;
    }

    @Override
    public Integer insert(Expense expense) {
    jdbcTemplate.update(INSERT_INTO_CATEGORY_EXPENSE, expense.getCategoryName().toLowerCase());


    Object[] params = {expense.getCategoryName()};
    int[] types = {1};

    ExpenseCategory expenseCategory = jdbcTemplate.queryForObject(
            SELECT_FROM_EXPENSE_CATEGORY_BY_NAME,
            params, types,
            new ExpenseCategroyRowMapper());

    return jdbcTemplate.update(INSERT_INTO_EXPENSE,
            expense.getDate(),
            expense.getDescription(),
            expense.getAmount(),
            expenseCategory.getId(),
            expenseCategory.getName());
    }

    static class ExpenseCategroyRowMapper implements RowMapper<ExpenseCategory> {
    @Override
        public ExpenseCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setId(rs.getLong("id"));
        expenseCategory.setName(rs.getString("name"));
        return expenseCategory;
    }
    }

/*
    //Datos que traigo de la DB
    @Override
    public List<ExpenseDto> getAll() {
        try(PreparedStatement statement = connection.prepareStatement(GET_ALL_EXPENSES)){
            ResultSet resultSet = statement.executeQuery();
            List<ExpenseDto> expenses = new ArrayList<>();
            //Itero el resultSet para agregar el gasto a la lista y
            //Mientras agrego, realizo el mapeo a cada item
            while (resultSet.next()){ // si existe un registro, lo agrego a la lista
                expenses.add(mapResultSetToExpenseDto(resultSet));
            }
            return expenses;
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la lista de gastos",e);
        }
    }

    @Override
    public void update(ExpenseDto expenseDto) {

    }

    @Override
    public void delete(Integer id) {

    }*/
}
