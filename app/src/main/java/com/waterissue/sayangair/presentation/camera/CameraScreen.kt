package com.waterissue.sayangair.presentation.camera

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.waterissue.sayangair.R
import com.waterissue.sayangair.presentation.camera.network.retrofit.ApiConfig
import com.waterissue.sayangair.presentation.camera.network.retrofit.ApiService
import com.waterissue.sayangair.presentation.main.component.Screen
import com.waterissue.sayangair.presentation.profile.Profile
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream
import java.nio.ByteBuffer
import kotlin.math.roundToInt
import okhttp3.RequestBody.Companion.create
import okhttp3.RequestBody.Companion.toRequestBody
import okio.ByteString.Companion.toByteString
import java.io.ByteArrayOutputStream

class CameraScreen : AppCompatActivity() {

    private lateinit var imagePicker: ImageView
    private lateinit var cameraButton: Button
    private lateinit var galleryButton: Button
    private lateinit var uploadButton: Button

    private var selectedImageUri: Uri? = null

    private val takePictureLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.extras?.get("data")?.let { imageBitmap ->
                    displayImageFromBitmap(imageBitmap)
                }
            }
        }

    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { imageUri ->
                    displayImage(imageUri)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_screen)

        imagePicker = findViewById(R.id.picker_image)
        cameraButton = findViewById(R.id.camera)
        galleryButton = findViewById(R.id.gallery)
        uploadButton = findViewById(R.id.unggah)

        uploadButton.isEnabled = false

        cameraButton.setOnClickListener { openCamera() }
        galleryButton.setOnClickListener { openGallery() }
        uploadButton.setOnClickListener { uploadImage() }
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureLauncher.launch(intent)
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickImageLauncher.launch(intent)
    }

    private fun displayImage(imageUri: Uri) {
        imagePicker.setImageURI(imageUri)
        selectedImageUri = imageUri

        uploadButton.isEnabled = true
    }

    private fun displayImageFromBitmap(imageBitmap: Any) {
        val tempUri = getImageUri(imageBitmap)
        tempUri?.let { uri ->
            displayImage(uri)
        }
    }

    private fun uploadImage() {
        if (selectedImageUri != null) {
            val currentUser = FirebaseAuth.getInstance().currentUser
            if (currentUser != null) {
                val userEmail = currentUser.email
                if (!userEmail.isNullOrEmpty()) {
                    val resizedImageByteArray = resizeImage(selectedImageUri!!, 600, 400)

                    val imageByteBuffer = ByteBuffer.wrap(resizedImageByteArray)

                    Log.d("upload image", "user email = $userEmail")
                    sendImageToTensorFlowAPI(imageByteBuffer, userEmail)

                    Toast.makeText(this, "Verifikasi Berhasil", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please select an image first", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendImageToTensorFlowAPI(imageByteBuffer: ByteBuffer, email: String) {
        val apiService = ApiConfig.getApiService()
        val imageByteString = imageByteBuffer.toByteString()
        val requestFile = imageByteString.toRequestBody("image/*".toMediaTypeOrNull())
        val imageBody = MultipartBody.Part.createFormData("image", "ktp3.png", requestFile)
        val emailRequestBody = email.toRequestBody("text/plain".toMediaTypeOrNull())

        apiService.uploadImageWithUserInfo(imageBody, emailRequestBody)
            .enqueue(object : Callback<ImageData> {
                override fun onResponse(call: Call<ImageData>, response: Response<ImageData>) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        Log.d("CameraScreen", "TensorFlow API Response: $result")

                    } else {
                        val errorBody = response.errorBody()?.string()
                        Log.e("CameraScreen", "TensorFlow API Error: $errorBody")

                    }
                }

                override fun onFailure(call: Call<ImageData>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

    private fun getImageUri(inImage: Any): Uri? {
        val imageBitmap = inImage as? Bitmap
        val file = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "temp.png")

        FileOutputStream(file).use {
            imageBitmap?.compress(Bitmap.CompressFormat.PNG, 100, it)
        }

        return Uri.fromFile(file)
    }

    private fun resizeImage(imageUri: Uri, targetWidth: Int, targetHeight: Int): ByteArray {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri), null, options)
        val imageWidth: Int = options.outWidth
        val imageHeight: Int = options.outHeight

        val scaleFactor = calculateScaleFactor(imageWidth, imageHeight, targetWidth, targetHeight)

        val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
        val resizedBitmap = Bitmap.createScaledBitmap(
            bitmap,
            (imageWidth * scaleFactor).toInt(),
            (imageHeight * scaleFactor).toInt(),
            true
        )

        val outputStream = ByteArrayOutputStream()
        resizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }

    private fun calculateScaleFactor(
        imageWidth: Int,
        imageHeight: Int,
        targetWidth: Int,
        targetHeight: Int
    ): Float {
        val widthRatio = targetWidth.toFloat() / imageWidth.toFloat()
        val heightRatio = targetHeight.toFloat() / imageHeight.toFloat()
        return if (widthRatio < heightRatio) widthRatio else heightRatio
    }
}