package com.waterissue.sayangair.presentation.payment.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.waterissue.sayangair.presentation.theme.BlueSea
import com.waterissue.sayangair.presentation.theme.LightBlue
import com.waterissue.sayangair.presentation.theme.LightSecondary

@Composable
fun PaymentDetail() {
    var selectedCard by remember { mutableStateOf<String?>(null) }
    var showSuccessDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Detail Pembayaran",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = LightSecondary,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "No. Pelanggan: 123456789",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Tanggal Pembayaran: 01 Desember 2023",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Pemakaian: 200 Liter",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Total Tagihan: Rp 20.000",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Denda: -",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Biaya Admin: Rp 2.500",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Metode Pembayaran",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                PaymentCard(
                    "BCA",
                    Icons.Default.AccountBox,
                    cardColor = LightBlue,
                    selectedCard,
                ) {
                    selectedCard = "BCA"
                }
                PaymentCard(
                    "BRI", Icons.Default.AccountBox, cardColor = LightBlue,
                    selectedCard
                ) {
                    selectedCard = "BRI"
                }
                PaymentCard(
                    "Mandiri", Icons.Default.AccountBox, cardColor = LightBlue,
                    selectedCard
                ) {
                    selectedCard = "Mandiri"
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (selectedCard != null) {
                    showSuccessDialog = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(
                    color = if (selectedCard != null) BlueSea else Color.Gray,
                    shape = RoundedCornerShape(8.dp)
                ),            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = if (selectedCard != null) BlueSea else Color.Green,
                disabledContentColor = contentColorFor(LightBlue)
            ),
            enabled = selectedCard != null
        ) {
            Text("Bayar")
        }

        if (showSuccessDialog) {
            AlertDialog(
                onDismissRequest = { showSuccessDialog = false },
                title = { Text("Pembayaran Berhasil") },
                text = { Text("Terima kasih! Pembayaran Anda telah berhasil.") },
                confirmButton = {
                    Button(onClick = { showSuccessDialog = false }) { Text("OK") }
                }
            )
        }
    }
}

@Composable
fun PaymentCard(
    cardName: String,
    icon: ImageVector,
    cardColor: Color,
    selectedCard: String?,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (cardName == selectedCard) cardColor else Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = cardName,
                fontSize = 15.sp,
                color = Color.Black
            )
        }
    }
}
