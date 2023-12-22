package com.waterissue.sayangair.presentation.reward.component

import androidx.annotation.DrawableRes
import com.waterissue.sayangair.R

sealed class RewardItem(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
    val expired: String,
    val pointsRequired: Int
) {
    object First : RewardItem(
        image = R.drawable.ic_voucher_1,
        title = "Voucher GoFood potongan harga 10.000",
        description = "20 poin",
        expired = "Masa berlaku sampai 14 Januari 2024",
        pointsRequired = 20
    )

    object Second : RewardItem(
        image = R.drawable.ic_voucher_2,
        title = "Voucher Tokopedia Beauty potongan harga 20%",
        description = "30 poin",
        expired = "Masa berlaku sampai 31 Januari 2024",
        pointsRequired = 30
    )

    object Third : RewardItem(
        image = R.drawable.ic_voucher_4,
        title = "Voucher bebas berlangganan Prime Video 3 hari",
        description = "15 poin",
        expired = "Masa berlaku sampai 4 Maret 2024",
        pointsRequired = 15
    )

    object Fourth : RewardItem(
        image = R.drawable.ic_voucher_3,
        title = "Voucher bebas akses Joox selama 3 hari",
        description = "15 poin",
        expired = "Masa berlaku sampai 20 Agustus 2024",
        pointsRequired = 15
    )
}