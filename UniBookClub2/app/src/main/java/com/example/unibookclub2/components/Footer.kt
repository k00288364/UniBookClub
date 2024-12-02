package com.example.unibooks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Footer() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(101.dp)
            .background(Color(0xFF09E832))
    )
}