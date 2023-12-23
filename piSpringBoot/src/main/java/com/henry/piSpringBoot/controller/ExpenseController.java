package com.henry.piSpringBoot.controller;


import com.henry.piSpringBoot.request.ExpenseRequestDto;
import com.henry.piSpringBoot.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    //Clase de servicio

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<String> createExpenseHandler(@RequestBody ExpenseRequestDto expenseRequestDto) throws SQLException {
        String response = expenseService.createExpense(expenseRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
