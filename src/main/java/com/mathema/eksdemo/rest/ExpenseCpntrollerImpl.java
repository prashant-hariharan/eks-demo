package com.mathema.eksdemo.rest;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mathema.eksdemo.domain.Expense;
import com.mathema.eksdemo.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseCpntrollerImpl implements ExpenseController {

  private final ExpenseService expenseService;

  @Autowired
  public ExpenseCpntrollerImpl(ExpenseService expenseService) {
    this.expenseService = expenseService;
  }

  @Override
  @PostMapping
  public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {

    return new ResponseEntity<Expense>(expenseService.createExpense(expense), HttpStatus.OK);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
    return new ResponseEntity<Expense>(expenseService.updateExpense(id, expense), HttpStatus.OK);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<Expense> findExpenseById(@PathVariable Long id) {
    return new ResponseEntity<Expense>(expenseService.getExpenseById(id), HttpStatus.OK);
  }

  @Override
  @GetMapping
  public ResponseEntity<Page<Expense>> findAllExpenses(@ParameterObject Pageable pageable) {
    return new ResponseEntity<>(expenseService.findAllExpenses(pageable), HttpStatus.OK);
  }

}
