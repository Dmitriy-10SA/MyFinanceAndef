package com.andef.myfinance.domain.expense.usecases

import com.andef.myfinance.domain.expense.entities.Expense
import com.andef.myfinance.domain.expense.repository.ExpenseRepository
import javax.inject.Inject

/**
 * Добавление расхода в таблицу расходов (БД)
 *
 * @see ExpenseRepository
 * @see Expense
 */
class AddExpenseUseCase @Inject constructor(private val repository: ExpenseRepository) {
    suspend operator fun invoke(expense: Expense) {
        repository.addExpense(expense = expense)
    }
}