package com.andef.myfinance.domain.income.usecases

import com.andef.myfinance.domain.income.entities.Income
import com.andef.myfinance.domain.income.repository.IncomeRepository
import javax.inject.Inject

/**
 * Получение дохода по id из таблицы доходов (БД)
 *
 * @see IncomeRepository
 * @see Income
 */
class GetIncomeUseCase @Inject constructor(private val repository: IncomeRepository) {
    suspend operator fun invoke(id: Int): Income {
        return repository.getIncome(id = id)
    }
}