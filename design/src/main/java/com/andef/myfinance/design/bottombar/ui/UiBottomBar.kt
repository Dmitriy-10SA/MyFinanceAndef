package com.andef.myfinance.design.bottombar.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.andef.myfinance.design.bottombar.item.UiBottomBarItem
import com.andef.myfinance.design.ui.theme.BrightLime
import com.andef.myfinance.design.ui.theme.RichBlack
import com.andef.myfinance.design.ui.theme.White

@Composable
fun UiBottomBar(
    items: List<UiBottomBarItem>,
    selectedItem: @Composable (UiBottomBarItem) -> Boolean,
    onItemClick: (UiBottomBarItem) -> Unit,
    isVisible: Boolean = true
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(durationMillis = 800)
        ),
        exit = slideOutVertically(
            targetOffsetY = { it },
            animationSpec = tween(durationMillis = 800)
        )
    ) {
        MainContent(
            items = items,
            selectedItem = selectedItem,
            onItemClick = onItemClick
        )
    }
}

@Composable
private fun MainContent(
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
            .clip(RoundedCornerShape(32.dp))
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
                    shape = RoundedCornerShape(32.dp)
                )
                .clip(shape = RoundedCornerShape(32.dp))
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
        modifier = Modifier.size(26.dp),
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
        Text(text = item.title, color = RichBlack)
    }
}