package com.andef.myfinance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andef.myfinance.design.bottombar.ui.UiBottomBar
import com.andef.myfinance.design.scaffold.ui.UiScaffold
import com.andef.myfinance.design.ui.theme.MyFinanceAndefTheme
import com.andef.myfinance.di.MyFinanceComponent
import com.andef.myfinance.navigation.Screen
import com.andef.myfinance.navigation.graph.AppNavGraph
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    private val component by lazy {
        (application as MyFinanceApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SettingSystemUi()
            MainContent(component = component)
        }
    }
}

@Composable
private fun SettingSystemUi() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Color.White, darkIcons = true)
}

@Composable
private fun MainContent(component: MyFinanceComponent) {
    val navHostController = rememberNavController()
    MyFinanceAndefTheme(dynamicColor = false) {
        UiScaffold(
            bottomBar = {
                MainBottomBar(navHostController = navHostController)
            }
        ) { paddingValues ->
            AppNavGraph(
                navHostController = navHostController,
                viewModelFactory = component.viewModelFactory,
                paddingValues = paddingValues
            )
        }
    }
}

@Composable
private fun MainBottomBar(navHostController: NavHostController) {
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
            it.destination.route in Screen.MainScreens.allScreensList.map {
                it.route
            }
        } == true
    )
}