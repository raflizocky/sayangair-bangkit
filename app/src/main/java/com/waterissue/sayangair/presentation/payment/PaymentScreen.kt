package com.waterissue.sayangair.presentation.payment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waterissue.sayangair.presentation.payment.component.PaymentDetail
import com.waterissue.sayangair.presentation.payment.component.User

@Composable
fun PaymentScreen() {
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


@Composable
@Preview(showBackground = true)
fun X() {
    PaymentScreen()
}
