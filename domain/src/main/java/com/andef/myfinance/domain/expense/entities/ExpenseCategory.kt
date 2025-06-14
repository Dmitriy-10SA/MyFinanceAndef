package com.andef.myfinance.domain.expense.entities

import com.andef.myfinance.domain.expense.entities.ExpenseCategory.CAFE
import com.andef.myfinance.domain.expense.entities.ExpenseCategory.CLOTHES
import com.andef.myfinance.domain.expense.entities.ExpenseCategory.GIFTS
import com.andef.myfinance.domain.expense.entities.ExpenseCategory.HEALTH
import com.andef.myfinance.domain.expense.entities.ExpenseCategory.HOME
import com.andef.myfinance.domain.expense.entities.ExpenseCategory.OTHER
import com.andef.myfinance.domain.expense.entities.ExpenseCategory.PRODUCTS
import com.andef.myfinance.domain.expense.entities.ExpenseCategory.SPORT
import com.andef.myfinance.domain.expense.entities.ExpenseCategory.STUDY
import com.andef.myfinance.domain.expense.entities.ExpenseCategory.TRANSPORT


/**
 * Категория траты
 *
 * @property PRODUCTS продукты
 * @property CAFE кафе
 * @property HOME дом
 * @property GIFTS подарки
 * @property STUDY учеба
 * @property HEALTH здоровье
 * @property TRANSPORT транспорт
 * @property SPORT спорт
 * @property CLOTHES одежда
 * @property OTHER другое
 *
 * @see Expense
 */
enum class ExpenseCategory(val title: String) {
    PRODUCTS(title = "Продукты"),
    CAFE(title = "Кафе"),
    HOME(title = "Дом"),
    GIFTS(title = "Подарки"),
    STUDY(title = "Учеба"),
    HEALTH(title = "Здоровье"),
    TRANSPORT(title = "Транспорт"),
    SPORT(title = "Спорт"),
    CLOTHES(title = "Одежда"),
    OTHER(title = "Другое")
}