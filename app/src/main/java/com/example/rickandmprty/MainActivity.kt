package com.example.rickandmprty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.domain.modules.Character
import com.example.domain.modules.Character.Location
import com.example.domain.modules.Character.Origin
import com.example.domain.modules.CharacterGender
import com.example.domain.modules.CharacterStatus
import com.example.network.KtorClient
import com.example.rickandmprty.screens.CharacterDetailsScreen
import com.example.rickandmprty.ui.theme.RickAndMprtyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            RickAndMprtyTheme {
                CharacterDetailsScreen(id = 173)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMprtyTheme {
        Greeting("Android")
    }
}