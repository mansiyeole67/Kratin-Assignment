package com.abhishek.kratinassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.abhishek.kratinassignment.ui.components.HomeScreen
import com.abhishek.kratinassignment.ui.components.MedicoApp
import com.abhishek.kratinassignment.ui.theme.KratinAssignmentTheme
import okhttp3.OkHttpClient

class MainActivity : ComponentActivity() {

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KratinAssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MedicoApp()
                }
            }
        }
    }

}