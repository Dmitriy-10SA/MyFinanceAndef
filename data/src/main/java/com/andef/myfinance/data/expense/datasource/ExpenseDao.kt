package com.andef.myfinance.data.expense.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.andef.myfinance.data.expense.dbmodel.ExpenseDbModel
import com.andef.myfinance.domain.expense.entities.ExpenseCategory
import kotlinx.coroutines.flow.Flow

/**
 * @property addExpense добавление расхода в таблицу расходов (БД)
 * @property changeExpense изменение расхода в таблице расходов (БД)
 * @property removeExpense удаление расхода из таблицы расходов (БД)
 * @property getExpense получение расхода по id из таблицы расходов (БД)
 * @property getExpenseList получение списка расходов из таблицы расходов (БД) по промежутку дат
 *
 * @see Expense
 * @see ExpenseDbModel
 * @see ExpenseDatabase
 * @see ExpenseCategory
 */
@Dao
interface ExpenseDao {
    @Insert
    suspend fun addExpense(expenseDbModel: ExpenseDbModel)

    @Query(
        """
        UPDATE expense
        SET amount = :amount, category = :category, description = :description, date = :date
        WHERE id = :id
    """
    )
    suspend fun changeExpense(
        id: Int,
        amount: Double,
        category: ExpenseCategory,
        description: String?,
        date: Int
    )

    @Query("DELETE FROM expense WHERE id = :id")
    suspend fun removeExpense(id: Int)

    @Query("SELECT * FROM expense WHERE id = :id")
    suspend fun getExpense(id: Int): ExpenseDbModel

    @Query("SELECT * FROM expense WHERE date BETWEEN :startDate AND :endDate")
    fun getExpenseList(startDate: Int, endDate: Int): Flow<List<ExpenseDbModel>>
}