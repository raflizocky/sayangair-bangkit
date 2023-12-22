package com.waterissue.sayangair.presentation.donation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.waterissue.sayangair.presentation.donation.DonationViewModel

@Composable
fun ArticleView(viewModel: DonationViewModel = hiltViewModel(), navController: NavController, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

        val articlesToDisplay = if (viewModel.query.value.isEmpty()) {
            viewModel.articles
        } else {
            viewModel.searchResult
        }

        items(articlesToDisplay.size) { index ->
            ArticleCard(article = articlesToDisplay[index], navController = navController)
        }
    }
}
