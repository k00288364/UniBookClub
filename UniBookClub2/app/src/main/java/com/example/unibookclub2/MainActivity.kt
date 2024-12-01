package com.example.unibookclub2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import com.example.unibooks.ui.theme.UniBooksTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniBooksTheme {
                MyApp()

            }
        }
        FirebaseApp.initializeApp(this)
    }
}