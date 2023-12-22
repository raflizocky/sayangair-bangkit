package com.waterissue.sayangair.presentation.login_register

import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.waterissue.sayangair.R

@Composable
fun RegisterScreen(
    onSignInClick: () -> Unit,
    onRegistrationSuccess: () -> Unit
) {
    val context = LocalContext.current

    AndroidView(
        factory = { context ->
            LayoutInflater.from(context)
                .inflate(R.layout.activity_register, null) as LinearLayout
        },
        modifier = Modifier.fillMaxSize()
    ) { view ->
        val edtTextEmail: TextInputEditText = view.findViewById(R.id.email)
        val edtTextPassword: TextInputEditText = view.findViewById(R.id.password)
        val signUp: Button = view.findViewById(R.id.sign_up)
        val signIn: TextView = view.findViewById(R.id.sign_in)

        signIn.setOnClickListener {
            onSignInClick()
        }

        signUp.setOnClickListener {
            val email = edtTextEmail.text.toString()
            val password = edtTextPassword.text.toString()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(context, "Enter Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onRegistrationSuccess()
                    } else {
                        Toast.makeText(context, "Authentication Failed", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}