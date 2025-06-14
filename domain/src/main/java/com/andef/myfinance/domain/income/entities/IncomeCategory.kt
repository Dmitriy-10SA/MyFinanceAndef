package com.andef.myfinance.domain.income.entities

import com.andef.myfinance.domain.income.entities.IncomeCategory.BANK
import com.andef.myfinance.domain.income.entities.IncomeCategory.GIFTS
import com.andef.myfinance.domain.income.entities.IncomeCategory.LUCK
import com.andef.myfinance.domain.income.entities.IncomeCategory.OTHER
import com.andef.myfinance.domain.income.entities.IncomeCategory.SALARY


/**
 * Категория дохода
 *
 * @property SALARY зарплата
 * @property BANK банк
 * @property LUCK удача
 * @property GIFTS подарки
 * @property OTHER другое
 *
 * @see Income
 */
enum class IncomeCategory(val title: String) {
    SALARY(title = "Зарплата"),
    BANK(title = "Банк"),
    LUCK(title = "Удача"),
    GIFTS(title = "Подарки"),
    OTHER(title = "Другое")
}