package com.waterissue.sayangair.presentation.main.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.waterissue.sayangair.presentation.home.HomeScreen
import com.waterissue.sayangair.presentation.login_register.LoginScreen
import com.waterissue.sayangair.presentation.login_register.RegisterScreen
import com.waterissue.sayangair.presentation.onboarding.WelcomeScreen
import com.waterissue.sayangair.presentation.onboarding.component.welcomePages
import com.waterissue.sayangair.presentation.profile.ProfileScreen

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
        composable(route = Screen.Login.route) {
            LoginScreen(
                onSignUpClick = { navController.navigate(Screen.Register.route) },
                onSignInSuccess = { navController.navigate(Screen.Home.route) }
            )
        }
        composable(route = Screen.Register.route) {
            RegisterScreen(
                onSignInClick = { navController.navigate(Screen.Login.route) },
                onRegistrationSuccess = { navController.navigate(Screen.Register.route) }
            )
        }
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
    }
}