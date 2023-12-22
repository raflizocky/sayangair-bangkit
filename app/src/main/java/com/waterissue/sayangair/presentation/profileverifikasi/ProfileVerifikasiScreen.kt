package com.waterissue.sayangair.presentation.profileverifikasi

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.waterissue.sayangair.R

class ProfileVerifikasiScreen : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textUsername: TextView
    private lateinit var textEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_verifikasi_screen)

        imageView = findViewById(R.id.imageView)
        textUsername = findViewById(R.id.textUsername)
        textEmail = findViewById(R.id.textEmail)

        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        user?.let {
            val username = extractUsernameFromEmail(user.email)
            textUsername.text = username
            textEmail.text = user.email
        }
    }

    private fun extractUsernameFromEmail(email: String?): String {
        return email?.substringBefore('@') ?: "Username"
    }
}