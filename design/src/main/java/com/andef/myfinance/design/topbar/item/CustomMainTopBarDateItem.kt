package com.andef.myfinance.design.topbar.item

sealed class CustomMainTopBarDateItem(val index: Int, val title: String) {
    data object Day : CustomMainTopBarDateItem(index = 0, title = "День")
    data object Week : CustomMainTopBarDateItem(index = 1, title = "Неделя")
    data object Month : CustomMainTopBarDateItem(index = 2, title = "Месяц")
    data object Year : CustomMainTopBarDateItem(index = 3, title = "Год")
    data object Period : CustomMainTopBarDateItem(index = 4, title = "Период")
}