package com.jkhetle.themovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jkhetle.themovies.ui.navigation.AppNavigationGraph
import com.jkhetle.themovies.ui.theme.TheMoviesTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheMoviesTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                ) {
                    AppEntryPoint()
                }
            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    AppNavigationGraph()
}
