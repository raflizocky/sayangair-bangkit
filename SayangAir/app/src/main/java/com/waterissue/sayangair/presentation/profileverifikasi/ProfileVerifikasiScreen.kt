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

        // Retrieve user information from Firebase Authentication
        val auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        user?.let {
            // Set the username based on the email
            val username = extractUsernameFromEmail(user.email)
            textUsername.text = username

            // Set the email
            textEmail.text = user.email

            // You can also load the user profile image here if available
            // Example: Glide.with(this).load(user.photoUrl).into(imageView)
        }
    }

    // Function to extract username from email
    private fun extractUsernameFromEmail(email: String?): String {
        return email?.substringBefore('@') ?: "Username"
    }
}
