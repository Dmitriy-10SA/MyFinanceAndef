package com.andef.myfinance.domain.income.usecases

import com.andef.myfinance.domain.income.repository.IncomeRepository
import javax.inject.Inject

/**
 * Удаление дохода из таблицы доходов (БД)
 *
 * @see IncomeRepository
 */
class RemoveIncomeUseCase @Inject constructor(private val repository: IncomeRepository) {
    suspend operator fun invoke(id: Int) {
        repository.removeIncome(id = id)
    }
}