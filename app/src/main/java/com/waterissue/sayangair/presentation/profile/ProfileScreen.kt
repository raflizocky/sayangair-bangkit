package com.waterissue.sayangair.presentation.profile

import com.waterissue.sayangair.presentation.camera.CameraScreen
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.waterissue.sayangair.R

@Preview
@Composable
fun ProfileScreen() {
    val context = LocalContext.current

    AndroidView(
        factory = { context ->
            LayoutInflater.from(context)
                .inflate(R.layout.activity_profile, null) as LinearLayout
        },
        modifier = Modifier.fillMaxSize()
    ) { view ->
        val auth = Firebase.auth
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textEmail: TextView = view.findViewById(R.id.textEmail)
        val buttonCamera: Button = view.findViewById(R.id.buttonCamera)

        val user = auth.currentUser
        user?.let {
            val email = user.email
            textEmail.text = email

            val bitmap = createBitmapWithText(email?.firstOrNull()?.toUpperCase())
            imageView.setImageBitmap(bitmap)
        }

        buttonCamera.setOnClickListener {
            val intent = Intent(context, CameraScreen::class.java)
            context.startActivity(intent)
        }
    }
}

fun createBitmapWithText(text: Char?): Bitmap {
    val bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    val paint = Paint()
    paint.color = Color.WHITE
    paint.textSize = 40f
    paint.textAlign = Paint.Align.CENTER

    val x = canvas.width / 2
    val y = (canvas.height / 2 - (paint.descent() + paint.ascent()) / 2)
    canvas.drawText(text.toString(), x.toFloat(), y, paint)

    return bitmap
}