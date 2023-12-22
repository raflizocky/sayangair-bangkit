package com.waterissue.sayangair.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.waterissue.sayangair.R

class Profile : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var imageView: ImageView
    private lateinit var textUsername: TextView
    private lateinit var textEmail: TextView
    private lateinit var buttonCamera: Button

    private val takePictureLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val imageUri = result.data?.data
                imageView.setImageURI(imageUri)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = Firebase.auth
        imageView = findViewById(R.id.imageView)
        textUsername = findViewById(R.id.textUsername)
        textEmail = findViewById(R.id.textEmail)
        buttonCamera = findViewById(R.id.buttonCamera)

        val user = auth.currentUser
        user?.let {
            val email = user.email
            textEmail.text = email
        }

        buttonCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePictureLauncher.launch(intent)
        }
    }
}
