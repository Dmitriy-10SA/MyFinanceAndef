package com.andef.myfinance.data.expense.repository

import com.andef.myfinance.data.expense.datasource.ExpenseDao
import com.andef.myfinance.data.expense.mapper.ExpenseMapper
import com.andef.myfinance.data.toInt
import com.andef.myfinance.domain.expense.entities.Expense
import com.andef.myfinance.domain.expense.entities.ExpenseCategory
import com.andef.myfinance.domain.expense.repository.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

/**
 * Репозиторий расходов (impl)
 *
 * @property addExpense добавление расхода в таблицу расходов (БД)
 * @property changeExpense изменение расхода в таблице расходов (БД)
 * @property removeExpense удаление расхода из таблицы расходов (БД)
 * @property getExpense получение расхода по id из таблицы расходов (БД)
 * @property getExpenseList получение списка расходов из таблицы расходов (БД) по промежутку дат
 *
 * @see Expense
 * @see ExpenseMapper
 * @see ExpenseRepository
 * @see ExpenseCategory
 */
class ExpenseRepositoryImpl @Inject constructor(
    private val expenseDao: ExpenseDao,
    private val expenseMapper: ExpenseMapper
) : ExpenseRepository {
    override suspend fun addExpense(expense: Expense) {
        val expenseDbModel = expenseMapper.map(expense = expense)
        expenseDao.addExpense(expenseDbModel = expenseDbModel)
    }

    override suspend fun changeExpense(
        id: Int,
        amount: Double,
        category: ExpenseCategory,
        description: String?,
        date: LocalDate
    ) {
        expenseDao.changeExpense(
            id = id,
            amount = amount,
            category = category,
            description = description,
            date = date.toInt()
        )
    }

    override suspend fun removeExpense(id: Int) {
        expenseDao.removeExpense(id = id)
    }

    override suspend fun getExpense(id: Int): Expense {
        val expenseDbModel = expenseDao.getExpense(id = id)
        return expenseMapper.map(expenseDbModel = expenseDbModel)
    }

    override fun getExpenseList(startDate: LocalDate, endDate: LocalDate): Flow<List<Expense>> {
        val listExpenseDbModel = expenseDao.getExpenseList(
            startDate = startDate.toInt(),
            endDate = endDate.toInt()
        )
        return expenseMapper.map(listExpenseDbModel = listExpenseDbModel)
    }
}