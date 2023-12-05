package com.waterissue.sayangair.presentation.payment

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
import androidx.navigation.NavHostController
import com.waterissue.sayangair.presentation.payment.component.PaymentDetail
import com.waterissue.sayangair.presentation.payment.component.User

@Composable
fun PaymentScreen(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                navController.navigate("payment_info")
            },
            modifier = Modifier
                .size(60.dp)
        ) {
            Icon(imageVector = Icons.Default.Info, contentDescription = null)
        }
    }
    Column {
        Banner()
        Line()
        Payment()
    }
}

@Composable
fun Banner() {
    Column {
        User()
    }
}

@Composable
fun Payment() {
    Column {
        PaymentDetail()
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
