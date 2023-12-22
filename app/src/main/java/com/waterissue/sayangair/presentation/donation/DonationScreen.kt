package com.waterissue.sayangair.presentation.donation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.waterissue.sayangair.presentation.donation.component.ArticleView
import com.waterissue.sayangair.presentation.donation.component.Search

@Composable
fun DonationScreen(viewModel: DonationViewModel = hiltViewModel(), navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                navController.navigate("donation_info")
            },
            modifier = Modifier
                .size(60.dp)
        ) {
            Icon(imageVector = Icons.Default.Info, contentDescription = null)
        }
    }
    Column {
        Banner(viewModel = viewModel)
        Line()
        Category(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun Banner(viewModel: DonationViewModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Search(viewModel = viewModel)
    }
}

@Composable
fun Category(
    viewModel: DonationViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        ArticleView(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun Line() {
    Divider(
        modifier = Modifier
            .paddingFromBaseline(5.dp),
        1.dp,
        Color.Gray
    )
}