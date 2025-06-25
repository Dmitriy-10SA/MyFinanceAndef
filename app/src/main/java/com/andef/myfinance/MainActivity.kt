package com.andef.myfinance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.andef.myfinance.design.scaffold.ui.UiScaffold
import com.andef.myfinance.design.topbar.item.CustomMainTopBarDateItem
import com.andef.myfinance.design.ui.theme.MyFinanceAndefTheme
import com.andef.myfinance.di.MyFinanceComponent
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
    MyFinanceAndefTheme(dynamicColor = false, darkTheme = false) {
        UiScaffold(
            bottomBar = {
                MainBottomBar(navHostController = navHostController)
            },
            topBar = {
                MainTopBar(
                    navHostController = navHostController,
                    onItemClick = {
                        when (it) {
                            CustomMainTopBarDateItem.Period -> {

                            }

                            else -> {

                            }
                        }
                    }
                )
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