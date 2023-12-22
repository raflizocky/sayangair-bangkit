package com.waterissue.sayangair.presentation.payment.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.waterissue.sayangair.presentation.theme.LightSecondary

@Composable
fun User() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 30.dp, start = 35.dp)
    ) {
        Text(
            text = "Tagihan air anda:",
            color = LightSecondary,
            fontSize = 25.sp,
        )
        Text(
            text = "(per 01 Desember 2023)",
            color = LightSecondary,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
