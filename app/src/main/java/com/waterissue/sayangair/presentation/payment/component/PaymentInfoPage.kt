package com.waterissue.sayangair.presentation.payment.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun PaymentInfoPage(navController: NavHostController) {
    IconButton(
        onClick =
        { navController.popBackStack() },
        modifier = Modifier
            .paddingFromBaseline(0.dp, 30.dp)
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Menu")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 80.dp, 0.dp, 0.dp)
    ) {

        FAQItem(
            question = "Selamat datang di halaman pembayaran!",
            answer = "Halaman ini bertujuan untuk memudahkan Anda dalam melakukan pembayaran tagihan air bulanan Anda."
        )

        FAQItem(
            question = "Bagaimana Cara Melakukan Pembayaran Tagihan Air Saya?",
            answer = "Anda bisa melakukan pembayaran tagihan air bulanan Anda dengan memilih metode pembayaran dan menekan tombol 'bayar'."
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun FAQItem(question: String, answer: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = question,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = answer,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}
