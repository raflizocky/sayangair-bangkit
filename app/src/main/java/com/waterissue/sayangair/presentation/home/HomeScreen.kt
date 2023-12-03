package com.waterissue.sayangair.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.waterissue.sayangair.R
import com.waterissue.sayangair.presentation.donation.DonationScreen
import com.waterissue.sayangair.presentation.home.component.NavigationItem
import com.waterissue.sayangair.presentation.main.component.Screen
import com.waterissue.sayangair.presentation.payment.PaymentScreen
import com.waterissue.sayangair.presentation.profile.ProfileScreen
import com.waterissue.sayangair.presentation.reward.RewardScreen
import com.waterissue.sayangair.presentation.theme.BlueSea
import com.waterissue.sayangair.presentation.theme.PeachChart

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier,
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeActivity()
            }
            composable(Screen.Reward.route) {
                RewardScreen()
            }
            composable(Screen.Payment.route) {
                PaymentScreen()
            }
            composable(Screen.Donation.route) {
                DonationScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = BlueSea,
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_reawrd),
                icon = Icons.Default.ShoppingCart,
                screen = Screen.Reward
            ),
            NavigationItem(
                title = stringResource(R.string.menu_bayar),
                icon = Icons.Default.Star,
                screen = Screen.Payment
            ),
            NavigationItem(
                title = stringResource(R.string.menu_donasi),
                icon = Icons.Default.Favorite,
                screen = Screen.Donation
            ),
            NavigationItem(
                title = stringResource(R.string.menu_profil),
                icon = Icons.Default.Settings,
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            val isSelected = currentRoute == item.screen.route
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (isSelected) PeachChart else Color.Gray
                    )
                },
                label = { Text(item.title) },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
