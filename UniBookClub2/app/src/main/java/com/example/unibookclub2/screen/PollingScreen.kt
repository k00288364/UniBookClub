package com.example.unibookclub2.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.unibooks.components.Header
import com.example.unibooks.components.Footer
import com.example.unibookclub2.R
import kotlinx.coroutines.coroutineScope

@Composable
fun PollingScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val bookVotes = remember{mutableStateMapOf("Book 1" to 0, "Book 2" to 0, "Book 3" to 0, "Book 4" to 0)}
    var suggestionInput by remember{mutableStateOf("")}


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
      item{            Header(drawerState = drawerState, coroutineScope = coroutineScope)}
        item{WhatNextSection()}
            item{BookOptions(bookVotes)}
                item{SuggestionSection(suggestionInput){newSuggestion->suggestionInput = newSuggestion} }
                    item{SubmitButton(onSubmit={
                        if(suggestionInput.isNotEmpty())
                        {
                            bookVotes[suggestionInput] = 0
                            suggestionInput=""
                        }
                    })}
                        item{Footer()}
    }
}


@Composable
fun WhatNextSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(440.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "What Next?",
            color = Color.Black,
            fontSize = 56.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(70.dp)
        )
    }
}

@Composable
fun BookOptions(bookVotes: MutableMap<String, Int>) {
    Column(
        modifier = Modifier.padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        bookVotes.forEach{
                (book, votes) -> BookButton(book, votes)
        {
            bookVotes[book] = bookVotes[book]!! + 1
        }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun BookButton(book: String, votes: Int, onVote: ()->Unit) {
    Button(
        onClick = onVote,
        modifier = Modifier
            .width(455.dp)
            .shadow(4.dp)
            .background(Color(0xFFD9D9D9), RoundedCornerShape(10.dp))
    ) {
        Text(
            text = "$book - Votes: $votes",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(9.dp)
        )
    }
}

@Composable
fun SuggestionSection(suggestionInput: String, onInputChange: (String)->Unit) {
    Column(
        modifier = Modifier.padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Want to read something else?",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = suggestionInput,
            onValueChange = onInputChange,
            modifier = Modifier
                .width(370.dp)
                .background(Color(0xFFD9D9D9)),
            placeholder = { Text("Suggestion...") }
        )
    }
}

@Composable
fun SubmitButton(onSubmit:() -> Unit) {
    Button(
        onClick = onSubmit,
        modifier = Modifier
            .padding(top = 16.dp)
            .width(260.dp)
            .shadow(5.dp)
            .background(Color(0xFF09E832), RoundedCornerShape(13.dp))
        //colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF09E832))
    ) {
        Text(
            text = "Submit",
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(23.dp, 0.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPollingScreen() {
    val navController = rememberNavController()
    PollingScreen(navController)
}