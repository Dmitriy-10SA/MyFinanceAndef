package com.andef.myfinance.domain.expense.usecases

import com.andef.myfinance.domain.expense.repository.ExpenseRepository
import javax.inject.Inject

/**
 * Удаление расхода из таблицы расходов (БД)
 *
 * @see ExpenseRepository
 */
class RemoveExpenseUseCase @Inject constructor(private val repository: ExpenseRepository) {
    suspend operator fun invoke(id: Int) {
        repository.removeExpense(id = id)
    }
}