package com.andef.myfinance.domain.income.usecases

import com.andef.myfinance.domain.income.entities.Income
import com.andef.myfinance.domain.income.repository.IncomeRepository
import javax.inject.Inject

/**
 * Добавление дохода в таблицу доходов (БД)
 *
 * @see IncomeRepository
 * @see Income
 */
class AddIncomeUseCase @Inject constructor(private val repository: IncomeRepository) {
    suspend operator fun invoke(income: Income) {
        repository.addIncome(income = income)
    }
}