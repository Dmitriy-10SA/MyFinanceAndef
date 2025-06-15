package com.andef.myfinance.navigation.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.andef.myfinance.ViewModelFactory
import com.andef.myfinance.navigation.Screen

fun NavGraphBuilder.mainScreensNavGraph(
    navHostController: NavHostController,
    viewModelFactory: ViewModelFactory,
    paddingValues: PaddingValues
) {
    navigation(
        startDestination = Screen.MainScreens.IncomeMainScreen.route,
        route = Screen.MainScreens.route
    ) {
        composable(route = Screen.MainScreens.IncomeMainScreen.route) {

        }
        composable(route = Screen.MainScreens.ExpenseMainScreen.route) {

        }
        composable(route = Screen.MainScreens.TotalMainScreen.route) {

        }
    }
}