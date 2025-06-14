package com.andef.myfinance.domain.income.usecases

import com.andef.myfinance.domain.income.entities.Income
import com.andef.myfinance.domain.income.repository.IncomeRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

/**
 * Получение списка доходов из таблицы доходов (БД) по промежутку дат
 *
 * @see IncomeRepository
 * @see Income
 */
class GetIncomeListUseCase @Inject constructor(private val repository: IncomeRepository) {
    operator fun invoke(startDate: LocalDate, endDate: LocalDate): Flow<List<Income>> {
        return repository.getIncomeList(startDate = startDate, endDate = endDate)
    }
}