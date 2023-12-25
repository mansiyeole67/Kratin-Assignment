package com.abhishek.kratinassignment

sealed class Screen(val route: String, val imageId: Int, val label: String) {
    object Home: Screen("home",R.drawable.round_home_24,"Home")
    object Meditation: Screen("meditation",R.drawable.meditation_icon,"Meditation")
    object Diet: Screen("diet",R.drawable.diet,"Diet")
    object Todo: Screen("todo",R.drawable.checkmark_icon, "Todo")
}