package com.andef.myfinance.data.utils

import java.time.LocalDate

/**
 * Перевод LocalDate в Int
 */
fun LocalDate.toInt(): Int {
    return year * 10000 + monthValue * 100 + dayOfMonth
}

/**
 * Перевод Int в LocalDate
 */
fun Int.toLocalDate(): LocalDate {
    val year = this / 10000
    val month = (this % 10000) / 100
    val day = this % 100
    return LocalDate.of(year, month, day)
}