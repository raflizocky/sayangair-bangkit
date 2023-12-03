package com.waterissue.sayangair.presentation.donation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.waterissue.sayangair.presentation.donation.component.ArticleView
import com.waterissue.sayangair.presentation.donation.component.Search

@Composable
fun DonationScreen(viewModel: DonationViewModel = hiltViewModel()) {
    Column {
        Banner(viewModel = viewModel)
        Line()
        Category(viewModel = viewModel)
    }
}

@Composable
fun Banner(viewModel: DonationViewModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Search(viewModel = viewModel)
    }
}

@Composable
fun Category(viewModel: DonationViewModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ArticleView(viewModel = viewModel)
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

@Composable
@Preview(showBackground = true)
fun X() {
    DonationScreen()
}
