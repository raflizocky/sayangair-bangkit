package com.waterissue.sayangair.presentation.camera.network

import com.google.gson.annotations.SerializedName

data class ResponseUser(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Status? = null
)

data class Data(

	@field:SerializedName("nik")
	val nik: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class Status(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)
