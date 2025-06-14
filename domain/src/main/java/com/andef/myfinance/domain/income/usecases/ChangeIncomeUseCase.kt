package com.andef.myfinance.domain.income.usecases

import com.andef.myfinance.domain.income.entities.IncomeCategory
import com.andef.myfinance.domain.income.repository.IncomeRepository
import java.time.LocalDate
import javax.inject.Inject

/**
 * Изменение дохода в таблице доходов (БД)
 *
 * @see IncomeRepository
 * @see IncomeCategory
 */
class ChangeIncomeUseCase @Inject constructor(private val repository: IncomeRepository) {
    suspend operator fun invoke(
        id: Int,
        amount: Double,
        category: IncomeCategory,
        description: String,
        date: LocalDate
    ) {
        repository.changeIncome(
            id = id,
            amount = amount,
            category = category,
            description = description,
            date = date
        )
    }
}