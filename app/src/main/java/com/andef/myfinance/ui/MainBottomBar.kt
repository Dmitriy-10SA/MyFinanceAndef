package com.andef.myfinance.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.andef.myfinance.design.bottombar.ui.UiBottomBar
import com.andef.myfinance.navigation.Screen

@Composable
fun MainBottomBar(navHostController: NavHostController) {
    UiBottomBar(
        items = Screen.MainScreens.allUiBottomBarItems,
        selectedItem = { item ->
            navHostController.currentBackStackEntryAsState().value?.let {
                it.destination.route == item.route
            } == true
        },
        onItemClick = { item ->
            navHostController.navigate(item.route) {
                popUpTo(Screen.MainScreens.IncomeMainScreen.route) {
                    saveState = true
                }
                restoreState = true
                launchSingleTop = true
            }
        },
        isVisible = navHostController.currentBackStackEntryAsState().value?.let {
            it.destination.route in Screen.MainScreens.allScreensList.map { it.route }
        } == true
    )
}