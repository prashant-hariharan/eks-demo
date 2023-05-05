package com.mathema.eksdemo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mathema.eksdemo.domain.Expense;
import com.mathema.eksdemo.exception.ResourceNotFoundException;
import com.mathema.eksdemo.repo.ExpenseRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {
  private final ExpenseRepo repo;

  @Autowired
  public ExpenseServiceImpl(ExpenseRepo repo) {
    this.repo = repo;
  }

  @Override
  public Expense createExpense(Expense expense) {
    log.info("creating an expense ");

    return repo.save(expense);
  }

  @Override
  public Expense getExpenseById(Long expenseId) {
    log.info("retrieving an expense with id {} ", expenseId);

    Optional<Expense> expenseOptional = repo.findById(expenseId);
    if (expenseOptional.isPresent()) {
      return expenseOptional.get();
    }
    throw new ResourceNotFoundException(expenseId);
  }

  @Override
  public Expense updateExpense(Long id, Expense expense) {
    log.info("updating an expense with id {} ", id);
    Expense expenseFromDb = getExpenseById(id);
    BeanUtils.copyProperties(expense, expenseFromDb);
    return repo.save(expenseFromDb);
  }

  @Override
  public void deleteExpense(Long id) {
    log.info("deleting an expense with id {} ", id);
    repo.deleteById(id);

  }

  @Override
  public Page<Expense> findAllExpenses(Pageable pageable) {
    log.info("find all Expenses");
    return repo.findAll(pageable);
  }

}
