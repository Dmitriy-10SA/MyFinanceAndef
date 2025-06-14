package com.andef.myfinance.domain.income.entities

import java.time.LocalDate

/**
 * Доход
 *
 * @property id идентификатор (автоинкрементируемый при добавлении, если равен нулю)
 * @property amount сумма дохода
 * @property category категория дохода
 * @property description описание дохода
 * @property date дата
 *
 * @see IncomeCategory
 */
data class Income(
    val id: Int = 0,
    val amount: Double,
    val category: IncomeCategory,
    val description: String? = null,
    val date: LocalDate
)
