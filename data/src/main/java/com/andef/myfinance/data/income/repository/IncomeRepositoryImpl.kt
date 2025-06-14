package com.andef.myfinance.data.income.repository

import com.andef.myfinance.data.income.datasource.IncomeDao
import com.andef.myfinance.data.income.mapper.IncomeMapper
import com.andef.myfinance.data.utils.toInt
import com.andef.myfinance.domain.income.entities.Income
import com.andef.myfinance.domain.income.entities.IncomeCategory
import com.andef.myfinance.domain.income.repository.IncomeRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

/**
 * Репозиторий доходов (impl)
 *
 * @property addIncome добавление дохода в таблицу доходов (БД)
 * @property changeIncome изменение дохода в таблице доходов (БД)
 * @property removeIncome удаление дохода из таблицы доходов (БД)
 * @property getIncome получение дохода по id из таблицы доходов (БД)
 * @property getIncomeList получение списка доходов из таблицы доходов (БД) по промежутку дат
 *
 * @see Income
 * @see IncomeCategory
 * @see IncomeRepository
 */
class IncomeRepositoryImpl @Inject constructor(
    private val incomeDao: IncomeDao,
    private val incomeMapper: IncomeMapper
) : IncomeRepository {
    override suspend fun addIncome(income: Income) {
        val incomeDbModel = incomeMapper.map(income)
        return incomeDao.addIncome(incomeDbModel = incomeDbModel)
    }

    override suspend fun changeIncome(
        id: Int,
        amount: Double,
        category: IncomeCategory,
        description: String?,
        date: LocalDate
    ) {
        incomeDao.changeIncome(
            id = id,
            amount = amount,
            category = category,
            description = description,
            date = date.toInt()
        )
    }

    override suspend fun removeIncome(id: Int) {
        incomeDao.removeIncome(id = id)
    }

    override suspend fun getIncome(id: Int): Income {
        val incomeDbModel = incomeDao.getIncome(id = id)
        return incomeMapper.map(incomeDbModel = incomeDbModel)
    }

    override fun getIncomeList(
        startDate: LocalDate,
        endDate: LocalDate
    ): Flow<List<Income>> {
        val listIncomeDbModel = incomeDao.getIncomeList(
            startDate = startDate.toInt(),
            endDate = endDate.toInt()
        )
        return incomeMapper.map(listIncomeDbModel = listIncomeDbModel)
    }
}