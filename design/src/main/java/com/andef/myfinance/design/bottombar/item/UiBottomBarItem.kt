package com.andef.myfinance.design.bottombar.item

data class UiBottomBarItem(
    val selectedItemResId: Int,
    val unselectedItemResId: Int,
    val title: String,
    val contentDescription: String,
    val route: String
)