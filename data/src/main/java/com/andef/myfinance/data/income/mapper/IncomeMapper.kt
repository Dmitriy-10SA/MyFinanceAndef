package com.andef.myfinance.data.income.mapper

import com.andef.myfinance.data.income.dbmodel.IncomeDbModel
import com.andef.myfinance.data.toInt
import com.andef.myfinance.data.toLocalDate
import com.andef.myfinance.domain.income.entities.Income
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Класс для изменения Income <-> IncomeDbModel (выполняет все необходимые операции)
 *
 * @property map
 *
 * @see Income
 * @see IncomeDbModel
 */
class IncomeMapper @Inject constructor() {
    fun map(income: Income): IncomeDbModel {
        return IncomeDbModel(
            id = income.id,
            amount = income.amount,
            category = income.category,
            description = income.description,
            date = income.date.toInt()
        )
    }

    fun map(incomeDbModel: IncomeDbModel): Income {
        return Income(
            id = incomeDbModel.id,
            amount = incomeDbModel.amount,
            category = incomeDbModel.category,
            description = incomeDbModel.description,
            date = incomeDbModel.date.toLocalDate()
        )
    }

    fun map(listIncomeDbModel: Flow<List<IncomeDbModel>>): Flow<List<Income>> {
        return listIncomeDbModel.map { listIncomeDbModelWithoutFlow ->
            listIncomeDbModelWithoutFlow.map { incomeDbModel ->
                this.map(incomeDbModel = incomeDbModel)
            }
        }
    }
}