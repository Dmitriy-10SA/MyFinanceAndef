package com.andef.myfinance.presentation.navigation

sealed class Screen(val route: String) {
    data object MainScreens : Screen(MAIN_SCREENS_ROUTE) {
        data object IncomeMainScreen : Screen(INCOME_MAIN_SCREEN_ROUTE)
        data object ExpenseMainScreen : Screen(EXPENSE_MAIN_SCREEN_ROUTE)
        data object TotalMainScreen : Screen(TOTAL_MAIN_SCREEN_ROUTE)

        val allScreensList = listOf(IncomeMainScreen, ExpenseMainScreen, TotalMainScreen)
    }

    companion object {
        private const val MAIN_SCREENS_ROUTE = "main-screens-route"
        private const val INCOME_MAIN_SCREEN_ROUTE = "income-main-screen-route"
        private const val EXPENSE_MAIN_SCREEN_ROUTE = "expense-main-screen-route"
        private const val TOTAL_MAIN_SCREEN_ROUTE = "total-main-screen-route"
    }
}