package com.andef.myfinance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.andef.myfinance.ui.theme.MyFinanceAndefTheme

class MainActivity : ComponentActivity() {
    private val component by lazy {
        (application as MyFinanceApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFinanceAndefTheme(darkTheme = false) {

            }
        }
    }
}