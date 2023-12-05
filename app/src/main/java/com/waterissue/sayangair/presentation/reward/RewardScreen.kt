package com.waterissue.sayangair.presentation.reward

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.waterissue.sayangair.presentation.reward.component.RewardItem
import com.waterissue.sayangair.presentation.theme.BlueSea
import com.waterissue.sayangair.presentation.theme.LightSecondary

@Composable
fun RewardScreen(viewModel: RewardViewModel = hiltViewModel(), navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                navController.navigate("reward_info")
            },
            modifier = Modifier
                .size(60.dp)
        ) {
            Icon(imageVector = Icons.Default.Info, contentDescription = null)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Jumlah Poin: ${viewModel.userPoints.value}",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = LightSecondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .padding(70.dp, 0.dp, 0.dp, 0.dp)
            )

            Divider(
                modifier = Modifier
                    .paddingFromBaseline(5.dp),
                1.dp,
                Color.Gray
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                itemsIndexed(viewModel.rewards) { _, reward ->
                    RewardItemCard(reward, viewModel)
                }
            }
        }
    }
}

@Composable
fun RewardItemCard(reward: RewardItem, viewModel: RewardViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RectangleShape
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(120.dp)
                .border(1.dp, color = Color.Gray, shape = RectangleShape)
        ) {
            Image(
                painter = painterResource(id = reward.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, color = Color.Gray, shape = RectangleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = reward.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = reward.description,
                fontSize = 14.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = reward.expired,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                OutlinedButton(
                    onClick = {
                        viewModel.claimVoucher(reward)
                    },
                    modifier = Modifier,
                    border = BorderStroke(1.dp, Color.Gray),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = BlueSea,
                        disabledContentColor = contentColorFor(Color.Gray)
                    ),
                    enabled = viewModel.claimResult.value == null
                ) {
                    Text(text = "Klaim", modifier = Modifier.align(Alignment.CenterVertically))
                }
            }
        }

        viewModel.claimResult.value?.let { claimResult ->
            when (claimResult) {
                is RewardViewModel.ClaimResult.Success -> {
                    AlertDialog(
                        onDismissRequest = {
                            viewModel.clearClaimResult()
                        },
                        title = { Text("Berhasil Klaim Voucher") },
                        text = { Text("Voucher ${claimResult.voucherTitle} telah berhasil di-klaim.") },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    viewModel.clearClaimResult()
                                }
                            ) {
                                Text("OK")
                            }
                        }
                    )
                }

                is RewardViewModel.ClaimResult.Failure -> {
                    AlertDialog(
                        onDismissRequest = {
                            viewModel.clearClaimResult()
                        },
                        title = { Text("Gagal Klaim Voucher") },
                        text = { Text(claimResult.message) },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    viewModel.clearClaimResult()
                                }
                            ) {
                                Text("OK")
                            }
                        }
                    )
                }

                else -> {}
            }
        }
    }
}
