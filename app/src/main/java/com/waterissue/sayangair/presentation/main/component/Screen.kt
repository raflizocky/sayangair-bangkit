package com.waterissue.sayangair.presentation.main.component

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome_screen")
    object Home : Screen("home_screen")
    object Reward : Screen("reward_screen")
    object Donation : Screen("donation_screen")
    object Payment : Screen("payment_screen")
    object Profile : Screen("profile_screen")
}