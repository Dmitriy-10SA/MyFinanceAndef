package com.andef.myfinance.navigation.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.andef.myfinance.ViewModelFactory
import com.andef.myfinance.navigation.Screen
import com.andef.myfinance.presentation.income.IncomeMainScreen
import java.time.LocalDate

fun NavGraphBuilder.mainScreensNavGraph(
    navHostController: NavHostController,
    viewModelFactory: ViewModelFactory,
    paddingValues: PaddingValues,
    mainStartDate: LocalDate,
    mainEndDate: LocalDate
) {
    navigation(
        startDestination = Screen.MainScreens.IncomeMainScreen.route,
        route = Screen.MainScreens.route
    ) {
        composable(route = Screen.MainScreens.IncomeMainScreen.route) {
            IncomeMainScreen(
                navHostController = navHostController,
                paddingValues = paddingValues,
                viewModelFactory = viewModelFactory,
                mainStartDate = mainStartDate,
                mainEndDate = mainEndDate
            )
        }
        composable(route = Screen.MainScreens.ExpenseMainScreen.route) {

        }
        composable(route = Screen.MainScreens.TotalMainScreen.route) {

        }
    }
}