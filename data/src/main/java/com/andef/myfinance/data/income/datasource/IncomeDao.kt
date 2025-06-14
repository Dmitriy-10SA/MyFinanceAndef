package com.andef.myfinance.data.income.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.andef.myfinance.data.income.dbmodel.IncomeDbModel
import com.andef.myfinance.domain.income.entities.IncomeCategory
import kotlinx.coroutines.flow.Flow

/**
 * @property addIncome добавление дохода в таблицу доходов (БД)
 * @property changeIncome изменение дохода в таблице доходов (БД)
 * @property removeIncome удаление дохода из таблицы доходов (БД)
 * @property getIncome получение дохода по id из таблицы доходов (БД)
 * @property getIncomeList получение списка доходов из таблицы доходов (БД) по промежутку дат
 *
 * @see IncomeDbModel
 * @see IncomeDatabase
 * @see IncomeCategory
 */
@Dao
interface IncomeDao {
    @Insert
    suspend fun addIncome(incomeDbModel: IncomeDbModel)

    @Query(
        """
        UPDATE income
        SET amount = :amount, category = :category, description = :description, date = :date
        WHERE id = :id
    """
    )
    suspend fun changeIncome(
        id: Int,
        amount: Double,
        category: IncomeCategory,
        description: String?,
        date: Int
    )

    @Query("DELETE FROM income WHERE id = :id")
    suspend fun removeIncome(id: Int)

    @Query("SELECT * FROM income WHERE id = :id")
    suspend fun getIncome(id: Int): IncomeDbModel

    @Query("SELECT * FROM income WHERE date BETWEEN :startDate AND :endDate")
    fun getIncomeList(startDate: Int, endDate: Int): Flow<List<IncomeDbModel>>
}