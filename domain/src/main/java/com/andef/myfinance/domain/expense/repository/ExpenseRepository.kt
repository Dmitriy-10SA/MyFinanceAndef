package com.andef.myfinance.domain.expense.repository

import com.andef.myfinance.domain.expense.entities.Expense
import com.andef.myfinance.domain.expense.entities.ExpenseCategory
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

/**
 * Репозиторий расходов
 *
 * @property addExpense добавление расхода в таблицу расходов (БД)
 * @property changeExpense изменение расхода в таблице расходов (БД)
 * @property removeExpense удаление расхода из таблицы расходов (БД)
 * @property getExpense получение расхода по id из таблицы расходов (БД)
 * @property getExpenseList получение списка расходов из таблицы расходов (БД) по промежутку дат
 *
 * @see Expense
 * @see ExpenseCategory
 */
interface ExpenseRepository {
    suspend fun addExpense(expense: Expense)
    suspend fun changeExpense(
        id: Int,
        amount: Double,
        category: ExpenseCategory,
        description: String?,
        date: LocalDate
    )

    suspend fun removeExpense(id: Int)
    suspend fun getExpense(id: Int): Expense
    fun getExpenseList(startDate: LocalDate, endDate: LocalDate): Flow<List<Expense>>
}