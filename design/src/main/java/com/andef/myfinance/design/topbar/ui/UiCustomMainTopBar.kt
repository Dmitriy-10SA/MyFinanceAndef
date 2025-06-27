package com.andef.myfinance.design.topbar.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andef.myfinance.design.R
import com.andef.myfinance.design.topbar.item.CustomMainTopBarDateItem
import com.andef.myfinance.design.ui.theme.RichBlack
import com.andef.myfinance.design.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiCustomMainTopBar(
    text: String,
    isVisible: Boolean,
    selectedItem: CustomMainTopBarDateItem,
    onNavigationIconClick: () -> Unit,
    onItemClick: (CustomMainTopBarDateItem) -> Unit
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = animEnter,
        exit = animExit
    ) {
        Column {
            TextAndNavButton(text = text, onNavigationIconClick = onNavigationIconClick)
            PeriodItemsTabs(selectedItem = selectedItem, onItemClick = onItemClick)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ColumnScope.PeriodItemsTabs(
    selectedItem: CustomMainTopBarDateItem,
    onItemClick: (CustomMainTopBarDateItem) -> Unit
) {
    val items = listOf(
        CustomMainTopBarDateItem.Day,
        CustomMainTopBarDateItem.Week,
        CustomMainTopBarDateItem.Month,
        CustomMainTopBarDateItem.Year,
        CustomMainTopBarDateItem.Period
    )
    ScrollableTabRow(
        containerColor = White,
        contentColor = RichBlack,
        edgePadding = 0.dp,
        selectedTabIndex = selectedItem.index,
        indicator = { tabPositions ->
            val currentTabPosition = tabPositions.getOrNull(selectedItem.index)
            if (currentTabPosition != null) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.BottomStart)
                        .offset(currentTabPosition.left + (currentTabPosition.width - 30.dp) / 2)
                        .height(5.dp)
                        .width(30.dp)
                        .clip(CircleShape)
                        .background(RichBlack)
                )
            }
        },
        divider = {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = RichBlack.copy(alpha = 0.2f),
                thickness = 1.dp
            )
        }
    ) {
        items.forEach { item ->
            Tab(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(shape = shape),
                selected = selectedItem.index == item.index,
                onClick = {
                    onItemClick(item)
                },
                text = { Text(text = item.title, fontSize = 14.sp, color = RichBlack) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ColumnScope.TextAndNavButton(text: String, onNavigationIconClick: () -> Unit) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = White,
            navigationIconContentColor = RichBlack,
            titleContentColor = RichBlack,
            actionIconContentColor = RichBlack
        ),
        navigationIcon = {
            IconButton(
                onClick = onNavigationIconClick
            ) {
                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "Кнопка меню"
                )
            }
        },
        title = { Text(text = text, color = RichBlack, fontSize = 24.sp) }
    )
}

private val shape = RoundedCornerShape(12.dp)

private val animEnter = slideInVertically(
    initialOffsetY = { -it },
    animationSpec = tween(durationMillis = 600)
)

private val animExit = slideOutVertically(
    targetOffsetY = { -it },
    animationSpec = tween(durationMillis = 600)
)