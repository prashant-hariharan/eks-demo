package com.mathema.eksdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathema.eksdemo.domain.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
}
