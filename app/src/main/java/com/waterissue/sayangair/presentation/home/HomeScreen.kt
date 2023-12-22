package com.waterissue.sayangair.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.waterissue.sayangair.R
import com.waterissue.sayangair.presentation.donation.DonationScreen
import com.waterissue.sayangair.presentation.donation.DonationViewModel
import com.waterissue.sayangair.presentation.donation.component.ArticleDetail
import com.waterissue.sayangair.presentation.donation.component.DonationInfoPage
import com.waterissue.sayangair.presentation.home.component.HomeInfoPage
import com.waterissue.sayangair.presentation.home.component.NavigationItem
import com.waterissue.sayangair.presentation.home.component.data.Customer
import com.waterissue.sayangair.presentation.home.component.data.WaterDetails
import com.waterissue.sayangair.presentation.home.component.data.WaterUsage
import com.waterissue.sayangair.presentation.main.component.Screen
import com.waterissue.sayangair.presentation.payment.PaymentScreen
import com.waterissue.sayangair.presentation.payment.component.PaymentInfoPage
import com.waterissue.sayangair.presentation.profile.ProfileScreen
import com.waterissue.sayangair.presentation.reward.RewardScreen
import com.waterissue.sayangair.presentation.reward.component.RewardInfoPage
import com.waterissue.sayangair.presentation.theme.BlueSea
import com.waterissue.sayangair.presentation.theme.LightSecondary

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val viewModel: DonationViewModel = hiltViewModel()
    val customerData = Customer(109771, "Jelty Jeine Kordak")
    val waterUsageData = WaterUsage(
        mapOf(
            "november" to WaterDetails(186000, 0, 93),
            "october" to WaterDetails(200000, 0, 100)
        )
    )

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
                HomeActivity(
                    navController = navController,
                    waterUsageData = waterUsageData
                )
            }
            composable(Screen.Reward.route) {
                RewardScreen(navController = navController)
            }
            composable(Screen.Payment.route) {
                PaymentScreen(navController = navController)
            }
            composable(Screen.Donation.route) {
                DonationScreen(navController = navController, viewModel = viewModel)
            }
            composable(
                "detail/{articleTitle}",
                arguments = listOf(navArgument("articleTitle") { type = NavType.StringType })
            ) { backStackEntry ->
                val articleTitle = backStackEntry.arguments?.getString("articleTitle")
                val article = viewModel.articles.firstOrNull { it.title == articleTitle }
                if (article != null) {
                    ArticleDetail(article = article)
                } else {

                }
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable("home_info") {
                HomeInfoPage(navController = navController)
            }
            composable("reward_info") {
                RewardInfoPage(navController = navController)
            }
            composable("payment_info") {
                PaymentInfoPage(navController = navController)
            }
            composable("donation_info") {
                DonationInfoPage(navController = navController)
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
                icon = ImageVector.vectorResource(id = R.drawable.ic_water),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_reawrd),
                icon = ImageVector.vectorResource(id = R.drawable.ic_voucher),
                screen = Screen.Reward
            ),
            NavigationItem(
                title = stringResource(R.string.menu_bayar),
                icon = ImageVector.vectorResource(id = R.drawable.ic_payment),
                screen = Screen.Payment
            ),
            NavigationItem(
                title = stringResource(R.string.menu_donasi),
                icon = ImageVector.vectorResource(id = R.drawable.ic_donation),
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
                        tint = if (isSelected) BlueSea else LightSecondary
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