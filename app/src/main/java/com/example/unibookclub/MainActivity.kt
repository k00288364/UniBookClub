package com.example.unibookclub
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.unibookclub.ui.theme.UniBookClubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniBookClubTheme {
                MyApp() // The main app UI
            }
        }
    }
}