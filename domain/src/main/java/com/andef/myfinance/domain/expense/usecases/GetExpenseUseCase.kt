package com.andef.myfinance.domain.expense.usecases

import com.andef.myfinance.domain.expense.entities.Expense
import com.andef.myfinance.domain.expense.repository.ExpenseRepository
import javax.inject.Inject

/**
 * Получение расхода по id из таблицы расходов (БД)
 *
 * @see ExpenseRepository
 * @see Expense
 */
class GetExpenseUseCase @Inject constructor(private val repository: ExpenseRepository) {
    suspend operator fun invoke(id: Int): Expense {
        return repository.getExpense(id = id)
    }
}