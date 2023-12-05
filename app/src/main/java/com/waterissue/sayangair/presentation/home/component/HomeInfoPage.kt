package com.waterissue.sayangair.presentation.home.component

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeInfoPage(navController: NavHostController) {

    IconButton(
        onClick = {
            navController.popBackStack()
        }, modifier = Modifier
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
            question = "Selamat datang di halaman home!",
            answer = "Halaman berisi infografis pemakaian air bulanan menunjukkan grafik visual tentang konsumsi air di rumah Anda selama satu bulan. Ini mencakup perbandingan dengan bulan sebelumnya dan menyajikan informasi tentang berapa biaya yang telah Anda hemat."
        )

        FAQItem(
            question = "Bagaimana cara melihat perbandingan pemakaian air bulan lalu?",
            answer = "Anda dapat melihat perbandingan pemakaian air bulan lalu di dalam infografis. Grafik akan menunjukkan seberapa besar perubahan pemakaian air dari bulan sebelumnya untuk membantu Anda memahami tren penggunaan."
        )

        FAQItem(
            question = "Bagaimana cara mengetahui berapa biaya yang telah dihemat?",
            answer = "Informasi tentang biaya yang dihemat akan ditampilkan dalam infografis. Anda dapat melihat jumlah uang yang telah Anda hemat sebagai akibat dari perubahan pola pemakaian air di rumah Anda."
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

@Composable
@Preview(showBackground = true)
fun InfoPagePreview() {
    HomeInfoPage(navController = rememberNavController())
}

