package com.abhishek.kratinassignment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abhishek.kratinassignment.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicoApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { AppBar() },

        bottomBar = {
            val activeColor = MaterialTheme.colorScheme.primary
            val activeContentColor = MaterialTheme.colorScheme.onPrimary
            val inactiveColor = MaterialTheme.colorScheme.primary
            val containerColor = MaterialTheme.colorScheme.primaryContainer

            val screens = listOf(Screen.Home,Screen.Meditation,Screen.Diet, Screen.Todo)

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            BottomAppBar {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(containerColor)
                        .padding(15.dp)
                ) {
                    screens.forEach { screen ->
                        BottomMenuItem(
                            item = screen,
                            isSelected = currentRoute.equals(screen.route),
                            activeColor = activeColor,
                            inactiveColor = inactiveColor,
                            activeContentColor = activeContentColor,
                            onItemClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }

    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            NavHost(navController = navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) {
                    HomeScreen()
                }
                composable(Screen.Meditation.route) {
                    MeditationScreen()
                }
                composable(Screen.Diet.route) {
                    DietScreen()
                }
                composable(Screen.Todo.route) {
                    TodoScreen()
                }
            }
        }
    }
}