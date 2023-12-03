package com.waterissue.sayangair.presentation.payment

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.waterissue.sayangair.presentation.payment.component.PaymentDetail
import com.waterissue.sayangair.presentation.payment.component.User

@Composable
fun PaymentScreen() {
    Column {
        Banner()
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
    PaymentDetail()
}

@Composable
@Preview(showBackground = true)
fun X() {
    PaymentScreen()
}