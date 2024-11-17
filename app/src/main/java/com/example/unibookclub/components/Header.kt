package com.example.unibookclub.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unibookclub.R

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF09E832))
            .padding(8.dp, 27.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(77.dp)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = "TUS",
            fontSize = 77.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.weight(1f))

        Column {
            repeat(3) {
                Divider(
                    color = Color.White,
                    thickness = 5.dp,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
            }
        }
    }
}