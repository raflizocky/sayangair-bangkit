package com.waterissue.sayangair.presentation.main.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.waterissue.sayangair.presentation.home.HomeScreen
import com.waterissue.sayangair.presentation.onboarding.WelcomeScreen
import com.waterissue.sayangair.presentation.onboarding.component.welcomePages

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController, pages = welcomePages)
        }
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
    }
}