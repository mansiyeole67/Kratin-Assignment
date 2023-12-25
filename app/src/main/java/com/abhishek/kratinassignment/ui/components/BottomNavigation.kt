package com.abhishek.kratinassignment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abhishek.kratinassignment.R
import com.abhishek.kratinassignment.Screen


@Composable
fun BottomMenuItem(
    item: Screen,
    isSelected: Boolean,
    activeColor: Color,
    activeContentColor: Color,
    inactiveColor: Color,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeColor else Color.Transparent)
                .padding(6.dp)
                .clickable {
                    onItemClick()
                }
        ) {
            Icon(
                painter = painterResource(item.imageId),
                contentDescription = item.label,
                tint = if (isSelected) activeContentColor else inactiveColor,
                modifier = Modifier.size(18.dp)
            )
        }
        Text(
            text = item.label,
            color = if (isSelected) inactiveColor else inactiveColor,
            fontSize = 10.sp,
            letterSpacing = 1.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
