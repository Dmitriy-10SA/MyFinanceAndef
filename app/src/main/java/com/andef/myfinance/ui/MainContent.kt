package com.andef.myfinance.ui

import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.andef.myfinance.design.scaffold.ui.UiScaffold
import com.andef.myfinance.design.topbar.item.CustomMainTopBarDateItem
import com.andef.myfinance.design.ui.theme.MyFinanceAndefTheme
import com.andef.myfinance.di.MyFinanceComponent
import com.andef.myfinance.navigation.graph.AppNavGraph
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(component: MyFinanceComponent) {
    var startDate by remember { mutableStateOf(LocalDate.now()) }
    var endDate by remember { mutableStateOf(LocalDate.now()) }
    var showDatePicker by remember { mutableStateOf(false) }
    val dateRangePickerState = rememberDateRangePickerState()

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
                        onItemClick(
                            item = it,
                            onPeriodClick = {
                                showDatePicker = true
                            },
                            onOtherClick = { dates ->
                                startDate = dates.first
                                endDate = dates.second
                            }
                        )
                    }
                )
            }
        ) { paddingValues ->
            AppNavGraph(
                navHostController = navHostController,
                viewModelFactory = component.viewModelFactory,
                paddingValues = paddingValues,
                mainStartDate = startDate,
                mainEndDate = endDate
            )
            if (showDatePicker) {
                MainDatePicker(
                    dateRangePickerState = dateRangePickerState,
                    onDismissRequest = { showDatePicker = false }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainDatePicker(
    dateRangePickerState: DateRangePickerState,
    onDismissRequest: () -> Unit
) {
    DatePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {

        },
        dismissButton = {

        },
        colors = DatePickerDefaults.colors(

        )
    ) {
        DateRangePicker(
            state = dateRangePickerState,
            colors = DatePickerDefaults.colors(
            )
        )
    }
}

private fun onItemClick(
    item: CustomMainTopBarDateItem,
    onPeriodClick: () -> Unit,
    onOtherClick: (Pair<LocalDate, LocalDate>) -> Unit
) {
    return when (item) {
        CustomMainTopBarDateItem.Day -> {
            onOtherClick(LocalDate.now() to LocalDate.now())
        }

        CustomMainTopBarDateItem.Month -> {
            onOtherClick(LocalDate.now().minusMonths(1) to LocalDate.now())
        }

        CustomMainTopBarDateItem.Period -> {
            onPeriodClick()
        }

        CustomMainTopBarDateItem.Week -> {
            onOtherClick(LocalDate.now().minusWeeks(1) to LocalDate.now())
        }

        CustomMainTopBarDateItem.Year -> {
            onOtherClick(LocalDate.now().minusYears(1) to LocalDate.now())
        }
    }
}