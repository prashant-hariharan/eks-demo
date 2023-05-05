package com.mathema.eksdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mathema.eksdemo.domain.Expense;

/**
 * Interface to expose CRUD operation for {@link Expense}
 * @author prashant
 *
 */
public interface ExpenseService {

  /**
   * Create Expense
   * @param expense - Expense Object to be saved
   * @return {@link Expense}
   */
  public Expense createExpense(Expense expense);

  /**
   * Fetches expense by Id
   * @param expenseId - Id of Expense
   * @return
   */
  public Expense getExpenseById(Long expenseId);

  /**
   * 
   * @param expenseId - Id of expense
   * @param expense - Expense Object
   * @return {@link Expense}
   */
  public Expense updateExpense(Long expenseId, Expense expense);

  /**
   * Deletes an expense
   * @param id  - Id of Expense
   */
  public void deleteExpense(Long id);

  /**
   * Lists all expenses in a pageable format
   * @param pageable - Pageable 
   * @return
   */
  Page<Expense> findAllExpenses(Pageable pageable);
}
