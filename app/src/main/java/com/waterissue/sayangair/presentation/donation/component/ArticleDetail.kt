package com.waterissue.sayangair.presentation.donation.component

import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ArticleDetail(article: Article) {
    var showDialog by remember { mutableStateOf(false) }
    var dialogResult by remember { mutableStateOf(false) }

    rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == ComponentActivity.RESULT_OK) {
            dialogResult = true
        }
    }

    fun showAlertDialog() {
        showDialog = true
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                // Handle dismiss request if needed
                showDialog = false
            },
            title = {
                Text(text = "Donasi Berhasil!")
            },
            text = {
                Text(text = "Terima kasih atas donasinya. Donasi Anda telah diterima.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Icon(Icons.Default.Done, contentDescription = null)
                    Text("OK")
                }
            }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = rememberAsyncImagePainter(article.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = article.title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = article.description,
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            InfoItem("Tanggal", article.date)

            InfoItem("Penerima Donasi", article.recipient)

            InfoItem("Target Donasi", "Rp ${article.goal}")

            InfoItem("Latar Belakang Proyek", article.backgroundStory)

            InfoItem("Metode Donasi", article.donationMethod)

            InfoItem("Transparansi Keuangan", article.financialTransparency)

            InfoItem("Dukungan Visual", article.visualSupport)

            InfoItem("Informasi Kontak", article.contactInfo)

            InfoItem("Pembaruan Terima Kasih", article.updatesAndThanks)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { showAlertDialog() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Donasi Sekarang")
        }
    }
}

@Composable
fun InfoItem(title: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = content,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}
