package com.waterissue.sayangair.presentation.camera

import com.google.gson.annotations.SerializedName

data class ImageData(
    @SerializedName("data")
    val data: Data,

    @SerializedName("status")
    val status: Status
)

data class Data(
    @SerializedName("email")
    val email: String,

    @SerializedName("nik")
    val nik: String
)

data class Status(
    @SerializedName("code")
    val code: Int,

    @SerializedName("message")
    val message: String
)