package com.waterissue.sayangair.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.waterissue.sayangair.presentation.home.component.CircularProgressBar

@Composable
fun HomeActivity() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 100.dp)
            ) {
                Text(
                    text = "Kamu menggunakan air sebanyak",
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            }

            Spacer(modifier = Modifier.height(100.dp))

            CircularProgressBar(percentage = 0.8f, number = 100)

            Spacer(modifier = Modifier.height(50.dp))

            ComparisonInfo(
                icon = Icons.Default.ArrowDropDown,
                value = "500 liter",
                description = "lebih rendah dari bulan lalu",
                valueColor = Color.Gray,
                descriptionColor = Color.Black
            )

            ComparisonInfo(
                icon = Icons.Default.Face,
                value = "Rp20.000",
                description = "lebih murah dari bulan lalu",
                valueColor = Color.Gray,
                descriptionColor = Color.Black
            )
        }
    }
}

@Composable
fun ComparisonInfo(
    icon: ImageVector,
    value: String,
    description: String,
    valueColor: Color = Color.Black,
    descriptionColor: Color = Color.Black
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(50.dp)
        )

        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = value,
                color = valueColor,
                fontSize = 16.sp
            )
            Text(
                text = description,
                color = descriptionColor,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeActivityPreview() {
    HomeActivity()
}