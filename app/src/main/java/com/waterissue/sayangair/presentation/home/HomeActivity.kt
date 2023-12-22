package com.waterissue.sayangair.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.waterissue.sayangair.R
import com.waterissue.sayangair.presentation.home.component.CircularProgressBar
import com.waterissue.sayangair.presentation.home.component.ComparisonCard
import com.waterissue.sayangair.presentation.home.component.data.Customer
import com.waterissue.sayangair.presentation.home.component.data.WaterDetails
import com.waterissue.sayangair.presentation.home.component.data.WaterUsage
import com.waterissue.sayangair.presentation.theme.LightBlue
import com.waterissue.sayangair.presentation.theme.LightSecondary
import com.waterissue.sayangair.presentation.theme.TealChart

@Composable
fun HomeActivity(
    navController: NavHostController,
    waterUsageData: WaterUsage,
) {
    val octoberData = waterUsageData.months["october"] ?: WaterDetails(0, 0, 0)
    val novemberData = waterUsageData.months["november"] ?: WaterDetails(0, 0, 0)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                navController.navigate("home_info")
            },
            modifier = Modifier
                .size(60.dp)
        ) {
            Icon(imageVector = Icons.Default.Info, contentDescription = null)
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Pemakaian Air",
                color = LightSecondary,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 40.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier
                    .padding(60.dp, 0.dp, 60.dp, 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressBar(waterUsageData = waterUsageData)
            }

            Spacer(modifier = Modifier.height(24.dp))

            ComparisonCard(
                icon = ImageVector.vectorResource(id = R.drawable.ic_arrow_down),
                value = "Pemakaian",
                description = "${novemberData.waterCubic - octoberData.waterCubic}" + " liter",
                cardColor = LightBlue,
                iconColor = Color.Blue
            )

            Spacer(modifier = Modifier.height(16.dp))

            ComparisonCard(
                icon = Icons.Default.Face,
                value = "Hemat",
                description = "Rp ${novemberData.bill - octoberData.bill}",
                cardColor = TealChart,
                iconColor = Color.Green
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}