package com.andef.myfinance.data.income.dbmodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andef.myfinance.domain.income.entities.IncomeCategory

/**
 * Доход, сущность для БД
 *
 * @property id идентификатор (автоинкрементируемый при добавлении, если равен нулю)
 * @property amount полученная сумма
 * @property category категория дохода
 * @property description описание дохода
 * @property date дата (в int)
 *
 * @see IncomeCategory
 */
@Entity(tableName = "income")
data class IncomeDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val amount: Double,
    val category: IncomeCategory,
    val description: String? = null,
    val date: Int
)