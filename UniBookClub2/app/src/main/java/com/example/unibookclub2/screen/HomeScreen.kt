package com.example.unibookclub2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.unibooks.components.Footer
import com.example.unibooks.components.Header
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80FFFFFF)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()



            Text(
                text = "Literary Lounge",
                fontSize = 65.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 107.dp)
            )

            Text(
                text = "Welcome to Literary Lounge, where pages come alive and discussions ignite! Dive into the world of literature with us as we journey through timeless classics, contemporary gems, and hidden literary treasures. Whether you're an avid reader, a casual page-turner, or just dipping your toes into the vast ocean of books, our virtual lounge offers a cozy space for book lovers of all kinds.\n\nDiscover new authors, explore diverse genres, and engage in thought-provoking conversations with fellow bookworms from around the globe. From lively book discussions and author interviews to exclusive member perks and curated reading lists, Literary Lounge is your go-to destination for all things literary.\n\nJoin our vibrant community, share your passion for reading, and let the pages of your favorite books come to life in the Literary Lounge!",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 39.dp, start = 16.dp, end = 16.dp)
            )

            Button(
                onClick = { /* TODO: Implement login functionality */ },
                modifier = Modifier
                    .width(292.dp)
                    .padding(top = 33.dp)
                    .shadow(4.dp)
                    .background(Color(0xFF09E832), shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "Login",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Button(
                onClick = { /* TODO: Implement register functionality */ },
                modifier = Modifier
                    .width(292.dp)
                    .padding(top = 17.dp)
                    .shadow(4.dp)
                    .background(Color(0xFF09E832), shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "Register",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Footer()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController)
}