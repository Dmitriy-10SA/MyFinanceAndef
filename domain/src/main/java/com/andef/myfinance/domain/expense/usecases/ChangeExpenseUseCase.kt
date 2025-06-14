package com.andef.myfinance.domain.expense.usecases

import com.andef.myfinance.domain.expense.entities.ExpenseCategory
import com.andef.myfinance.domain.expense.repository.ExpenseRepository
import java.time.LocalDate
import javax.inject.Inject

/**
 * Изменение расхода в таблице расходов (БД)
 *
 * @see ExpenseRepository
 * @see ExpenseCategory
 */
class ChangeExpenseUseCase @Inject constructor(private val repository: ExpenseRepository) {
    suspend operator fun invoke(
        id: Int,
        amount: Double,
        category: ExpenseCategory,
        description: String?,
        date: LocalDate
    ) {
        repository.changeExpense(
            id = id,
            amount = amount,
            category = category,
            description = description,
            date = date
        )
    }
}