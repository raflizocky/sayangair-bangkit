package com.waterissue.sayangair.presentation.camera.network.retrofit

import com.waterissue.sayangair.presentation.camera.ImageData
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("prediction")
    fun uploadImageWithUserInfo(
        @Part file: MultipartBody.Part,
        @Part("email") email: okhttp3.RequestBody
    ): Call<ImageData>
}