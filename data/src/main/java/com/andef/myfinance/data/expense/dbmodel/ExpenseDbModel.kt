package com.andef.myfinance.data.expense.dbmodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andef.myfinance.domain.expense.entities.ExpenseCategory

/**
 * Расход, сущность для БД
 *
 * @property id идентификатор (автоинкрементируемый при добавлении, если равен нулю)
 * @property amount потраченная сумма
 * @property category категория траты
 * @property description описание траты
 * @property date дата (в int)
 *
 * @see ExpenseCategory
 */
@Entity(tableName = "expense")
data class ExpenseDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val amount: Double,
    val category: ExpenseCategory,
    val description: String? = null,
    val date: Int
)