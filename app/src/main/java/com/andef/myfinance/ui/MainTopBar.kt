package com.andef.myfinance.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.andef.myfinance.design.topbar.item.CustomMainTopBarDateItem
import com.andef.myfinance.design.topbar.ui.UiCustomMainTopBar
import com.andef.myfinance.navigation.Screen

@Composable
fun MainTopBar(
    navHostController: NavHostController,
    onItemClick: (CustomMainTopBarDateItem) -> Unit
) {
    var dateItem by remember {
        mutableStateOf(CustomMainTopBarDateItem.Day as CustomMainTopBarDateItem)
    }
    UiCustomMainTopBar(
        text = getTextForMainTopBar(navHostController = navHostController),
        isVisible = navHostController.currentBackStackEntryAsState().value?.let {
            it.destination.route in Screen.MainScreens.allScreensList.map { it.route }
        } == true,
        onNavigationIconClick = {
            TODO()
        },
        selectedItem = dateItem,
        onItemClick = {
            dateItem = it
            onItemClick(it)
        }
    )
}

@Composable
private fun getTextForMainTopBar(navHostController: NavHostController): String {
    val currentRoute = navHostController.currentBackStackEntryAsState().value?.destination?.route
    return when (currentRoute) {
        Screen.MainScreens.IncomeMainScreen.route -> {
            "Доходы"
        }

        Screen.MainScreens.ExpenseMainScreen.route -> {
            "Расходы"
        }

        Screen.MainScreens.TotalMainScreen.route -> {
            "Итоги"
        }

        else -> {
            ""
        }
    }
}