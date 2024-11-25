package com.example.unibookclub2.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.unibooks.components.Header
import com.example.unibooks.components.Footer

@Composable
fun MeetUpsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Spacer(modifier = Modifier.height(215.dp))
        Text(
            text = "Meet-Ups",
            fontSize = 56.sp,
            fontFamily = androidx.compose.ui.text.font.FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(20.dp))
        MeetUpTable()
        Spacer(modifier = Modifier.height(30.dp))
        NextReadsButton()
        Spacer(modifier = Modifier.height(20.dp))
        Footer()
    }
}


@Composable
fun MeetUpTable() {
    Column(
        modifier = Modifier
            .width(544.dp)
            .border(1.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFD9D9D9))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TableHeader("Book")
            TableHeader("Location")
            TableHeader("Date")
        }
        MeetUpRow("Romeo\nand\nJuliet", "TUS Library", "22/11/2024")
        repeat(3) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFFD9D9D9))
                    .border(1.dp, Color.Black)
            )
        }
    }
}

@Composable
fun TableHeader(text: String) {
    Text(
        text = text,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun MeetUpRow(book: String, location: String, date: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD9D9D9))
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = book,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = location,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = date,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun NextReadsButton() {
    Button(
        onClick = { /* TODO: Implement next reads action */ },
        modifier = Modifier
            .width(324.dp)
            .height(72.dp)
            .shadow(4.dp, RoundedCornerShape(10.dp))
            .background(Color(0xFF09E832), RoundedCornerShape(10.dp))
    ) {
        Text(
            text = "Next Reads!",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMeetUpsScreen() {
    val navController = rememberNavController()
    MeetUpsScreen(navController)
}