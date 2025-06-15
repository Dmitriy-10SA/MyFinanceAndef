package com.andef.myfinance.navigation

import com.andef.myfinance.design.R
import com.andef.myfinance.design.bottombar.item.UiBottomBarItem

sealed class Screen(val route: String) {
    data object MainScreens : Screen(MAIN_SCREENS_ROUTE) {
        data object IncomeMainScreen : Screen(INCOME_MAIN_SCREEN_ROUTE)
        data object ExpenseMainScreen : Screen(EXPENSE_MAIN_SCREEN_ROUTE)
        data object TotalMainScreen : Screen(TOTAL_MAIN_SCREEN_ROUTE)

        val allScreensList = listOf(IncomeMainScreen, ExpenseMainScreen, TotalMainScreen)
        val allUiBottomBarItems = listOf(
            UiBottomBarItem(
                selectedItemResId = R.drawable.income,
                unselectedItemResId = R.drawable.income,
                title = "Доходы",
                contentDescription = "Значок для доходов",
                route = Screen.MainScreens.IncomeMainScreen.route
            ),
            UiBottomBarItem(
                selectedItemResId = R.drawable.expense,
                unselectedItemResId = R.drawable.expense,
                title = "Расходы",
                contentDescription = "Значок для трат",
                route = Screen.MainScreens.ExpenseMainScreen.route
            ),
            UiBottomBarItem(
                selectedItemResId = R.drawable.total,
                unselectedItemResId = R.drawable.total,
                title = "Итоги",
                contentDescription = "Значок для итогов",
                route = Screen.MainScreens.TotalMainScreen.route
            )
        )
    }

    companion object {
        private const val MAIN_SCREENS_ROUTE = "main-screens-route"
        private const val INCOME_MAIN_SCREEN_ROUTE = "income-main-screen-route"
        private const val EXPENSE_MAIN_SCREEN_ROUTE = "expense-main-screen-route"
        private const val TOTAL_MAIN_SCREEN_ROUTE = "total-main-screen-route"
    }
}