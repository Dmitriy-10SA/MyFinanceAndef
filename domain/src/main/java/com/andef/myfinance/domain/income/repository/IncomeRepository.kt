package com.andef.myfinance.domain.income.repository

import com.andef.myfinance.domain.income.entities.Income
import com.andef.myfinance.domain.income.entities.IncomeCategory
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

/**
 * Репозиторий доходов
 *
 * @property addIncome добавление дохода в таблицу доходов (БД)
 * @property changeIncome изменение дохода в таблице доходов (БД)
 * @property removeIncome удаление дохода из таблицы доходов (БД)
 * @property getIncome получение дохода по id из таблицы доходов (БД)
 * @property getIncomeList получение списка доходов из таблицы доходов (БД) по промежутку дат
 *
 * @see Income
 * @see IncomeCategory
 */
interface IncomeRepository {
    suspend fun addIncome(income: Income)
    suspend fun changeIncome(
        id: Int,
        amount: Double,
        category: IncomeCategory,
        description: String?,
        date: LocalDate
    )

    suspend fun removeIncome(id: Int)
    suspend fun getIncome(id: Int): Income
    fun getIncomeList(startDate: LocalDate, endDate: LocalDate): Flow<List<Income>>
}