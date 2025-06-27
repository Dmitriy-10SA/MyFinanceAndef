package com.andef.myfinance.navigation.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.andef.myfinance.ViewModelFactory
import com.andef.myfinance.navigation.Screen
import java.time.LocalDate

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    viewModelFactory: ViewModelFactory,
    paddingValues: PaddingValues,
    mainStartDate: LocalDate,
    mainEndDate: LocalDate
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.MainScreens.route
    ) {
        mainScreensNavGraph(
            navHostController = navHostController,
            viewModelFactory = viewModelFactory,
            paddingValues = paddingValues,
            mainStartDate = mainStartDate,
            mainEndDate = mainEndDate
        )
    }
}