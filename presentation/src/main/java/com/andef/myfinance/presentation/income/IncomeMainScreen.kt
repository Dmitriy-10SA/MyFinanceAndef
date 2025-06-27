package com.andef.myfinance.presentation.income

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.andef.myfinance.ViewModelFactory
import java.time.LocalDate

@Composable
fun IncomeMainScreen(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    viewModelFactory: ViewModelFactory,
    mainStartDate: LocalDate,
    mainEndDate: LocalDate
) {
    val animTopPadding by animateDpAsState(
        targetValue = paddingValues.calculateTopPadding(),
        animationSpec = tween(600)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = animTopPadding)
            .navigationBarsPadding()
    ) {
        Text(text = "$mainStartDate - $mainEndDate")
    }
}