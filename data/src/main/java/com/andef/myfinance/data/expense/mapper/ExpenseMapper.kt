package com.andef.myfinance.data.expense.mapper

import com.andef.myfinance.data.expense.dbmodel.ExpenseDbModel
import com.andef.myfinance.data.toInt
import com.andef.myfinance.data.toLocalDate
import com.andef.myfinance.domain.expense.entities.Expense
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Класс для изменения Expense <-> ExpenseDbModel (выполняет все необходимые операции)
 *
 * @property map
 *
 * @see Expense
 * @see ExpenseDbModel
 */
class ExpenseMapper @Inject constructor() {
    fun map(expense: Expense): ExpenseDbModel {
        return ExpenseDbModel(
            id = expense.id,
            amount = expense.amount,
            category = expense.category,
            description = expense.description,
            date = expense.date.toInt()
        )
    }

    fun map(expenseDbModel: ExpenseDbModel): Expense {
        return Expense(
            id = expenseDbModel.id,
            amount = expenseDbModel.amount,
            category = expenseDbModel.category,
            description = expenseDbModel.description,
            date = expenseDbModel.date.toLocalDate()
        )
    }

    fun map(listExpenseDbModel: Flow<List<ExpenseDbModel>>): Flow<List<Expense>> {
        return listExpenseDbModel.map { listExpenseDbModelWithoutFlow ->
            listExpenseDbModelWithoutFlow.map { expenseDbModel ->
                this.map(expenseDbModel = expenseDbModel)
            }
        }
    }
}