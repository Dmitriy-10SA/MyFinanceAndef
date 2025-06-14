package com.andef.myfinance.domain.expense.usecases

import com.andef.myfinance.domain.expense.entities.Expense
import com.andef.myfinance.domain.expense.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

/**
 * Получение списка расходов из таблицы расходов (БД) по промежутку дат
 *
 * @see ExpenseRepository
 * @see Expense
 */
class GetExpenseListUseCase @Inject constructor(private val repository: ExpenseRepository) {
    operator fun invoke(startDate: LocalDate, endDate: LocalDate): Flow<List<Expense>> {
        return repository.getExpenseList(startDate = startDate, endDate = endDate)
    }
}