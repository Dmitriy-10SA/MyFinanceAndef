package com.andef.myfinance.design.bottombar.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andef.myfinance.design.R
import com.andef.myfinance.design.bottombar.item.UiBottomBarItem
import com.andef.myfinance.design.ui.theme.BrightLime
import com.andef.myfinance.design.ui.theme.RichBlack
import com.andef.myfinance.design.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun UiBottomBar(
    items: List<UiBottomBarItem>,
    selectedItem: @Composable (UiBottomBarItem) -> Boolean,
    onItemClick: (UiBottomBarItem) -> Unit,
    isVisible: Boolean = true
) {
    var bottomBarVisible by remember { mutableStateOf(true) }
    var showBottomBar by remember { mutableStateOf(true) }
    var showUpBottomBarIcon by remember { mutableStateOf(false) }
    LaunchedEffect(bottomBarVisible) {
        if (bottomBarVisible) {
            showUpBottomBarIcon = false
            delay(650)
            showBottomBar = true
        } else {
            showBottomBar = false
            delay(650)
            showUpBottomBarIcon = true
        }
    }
    Box {
        AnimatedVisibility(
            visible = isVisible && showBottomBar,
            enter = animEnter,
            exit = animExit
        ) {
            Box {
                MainContent(
                    items = items,
                    selectedItem = selectedItem,
                    onItemClick = onItemClick
                )
                CurrentVisibleButton(
                    modifier = Modifier.align(Alignment.TopStart),
                    contentDescription = "Скрыть панель навигации",
                    painter = painterResource(R.drawable.arrow_drop_down),
                    onClick = { bottomBarVisible = false }
                )
            }
        }
        AnimatedVisibility(
            visible = isVisible && showUpBottomBarIcon,
            enter = animEnter,
            exit = animExit
        ) {
            CurrentVisibleButton(
                modifier = Modifier
                    .padding(12.dp)
                    .navigationBarsPadding(),
                painter = painterResource(R.drawable.arrow_drop_up),
                contentDescription = "Раскрыть панель навигации",
                onClick = { bottomBarVisible = true }
            )
        }
    }
}

@Composable
private fun BoxScope.CurrentVisibleButton(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = RichBlack,
            contentColor = White
        ),
        onClick = onClick
    ) {
        Icon(
            tint = White,
            painter = painter,
            contentDescription = contentDescription
        )
    }
}

@Composable
private fun BoxScope.MainContent(
    items: List<UiBottomBarItem>,
    selectedItem: @Composable (UiBottomBarItem) -> Boolean,
    onItemClick: (UiBottomBarItem) -> Unit
) {
    Surface(
        color = RichBlack,
        contentColor = White,
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(12.dp)
            .clip(shape = shape)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectableGroup()
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AllItemsUi(
                items = items,
                selectedItem = selectedItem,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
private fun RowScope.AllItemsUi(
    items: List<UiBottomBarItem>,
    selectedItem: @Composable (UiBottomBarItem) -> Boolean,
    onItemClick: (UiBottomBarItem) -> Unit
) {
    items.forEach { item ->
        val selectedItem = selectedItem(item)
        Row(
            modifier = Modifier
                .weight(if (selectedItem) 2f else 1f)
                .background(
                    color = if (selectedItem) {
                        BrightLime
                    } else {
                        Color.Transparent
                    },
                    shape = shape
                )
                .clip(shape = shape)
                .clickable(
                    onClick = {
                        if (!selectedItem) onItemClick(item)
                    }
                )
                .padding(vertical = 12.dp, horizontal = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconAndText(selectedItem = selectedItem, item = item)
        }
    }
}

@Composable
private fun RowScope.IconAndText(selectedItem: Boolean, item: UiBottomBarItem) {
    Icon(
        modifier = Modifier.size(24.dp),
        painter = if (selectedItem) {
            painterResource(item.selectedItemResId)
        } else {
            painterResource(item.unselectedItemResId)
        },
        tint = if (selectedItem) {
            RichBlack
        } else {
            White
        },
        contentDescription = item.contentDescription
    )
    if (selectedItem) {
        Spacer(modifier = Modifier.padding(3.dp))
        Text(text = item.title, color = RichBlack, fontSize = 14.sp)
    }
}

private val shape = RoundedCornerShape(size = 32.dp)

private val animEnter = slideInVertically(
    initialOffsetY = { it },
    animationSpec = tween(durationMillis = 600)
)

private val animExit = slideOutVertically(
    targetOffsetY = { it },
    animationSpec = tween(durationMillis = 600)
)