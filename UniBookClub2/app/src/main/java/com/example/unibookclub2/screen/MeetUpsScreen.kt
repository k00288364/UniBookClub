package com.example.unibookclub2.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.unibooks.components.Header
import com.example.unibooks.components.Footer
import com.example.unibookclub2.R

//google maps imports
//import com.google.maps.android.compose.GoogleMap
//import com.google.maps.android.compose.Marker
//import com.google.maps.android.compose.rememberCameraPositionState
//import com.google.android.gms.maps.model.LatLng


@Composable
fun MeetUpsScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Header(drawerState = drawerState, coroutineScope = coroutineScope)
            }

            item {
                Spacer(modifier = Modifier.height(215.dp))
            }

            item {
                Text(
                    text = "Meet-Ups",
                    fontSize = 56.sp,
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Serif
                )

            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                MeetUpTable()
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }

            item {
                NextReadsButton(navController = navController)
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                Footer()
            }
        }
    }

    @Composable
    fun MeetUpTable() {
        Column(
            modifier = Modifier
                .width(400.dp)
                .fillMaxWidth()
                .border(1.dp, Color.Black)
        )
        {


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

            val meetups = listOf(
                Triple("Romeo\nand\nJuliet", "TUS Library", "22/11/2024"),
                Triple("The Great Gatsby", "Library A", "25/11/2024"),
                Triple("1984", "Main Hall", "30/11/2024"),
                Triple("Moby Dick", "Room 101", "05/12/2024")
            )


            meetups.forEach { meetup ->
                MeetUpRow(meetup.first, meetup.second, meetup.third)
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
    fun NextReadsButton(navController: NavHostController) {
        Button(
            onClick = { navController.navigate("polling") },
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