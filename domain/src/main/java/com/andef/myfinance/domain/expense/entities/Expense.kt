package com.andef.myfinance.domain.expense.entities

import java.time.LocalDate

/**
 * Расход
 *
 * @property id идентификатор (автоинкрементируемый при добавлении, если равен нулю)
 * @property amount сумма траты
 * @property category категория траты
 * @property description описание траты
 * @property date дата
 *
 * @see ExpenseCategory
 */
data class Expense(
    val id: Int = 0,
    val amount: Double,
    val category: ExpenseCategory,
    val description: String? = null,
    val date: LocalDate
)
