package com.example.rickandmprty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.domain.modules.Character
import com.example.domain.modules.Character.Location
import com.example.domain.modules.Character.Origin
import com.example.domain.modules.CharacterGender
import com.example.domain.modules.CharacterStatus
import com.example.network.KtorClient
import com.example.rickandmprty.screens.CharacterDetailsScreen
import com.example.rickandmprty.screens.CharacterEpisodeScreen
import com.example.rickandmprty.ui.theme.RickAndMprtyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            RickAndMprtyTheme {
                Scaffold(
                    contentWindowInsets = WindowInsets.systemBars // This handles it automatically
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = "character_details"){
                        composable("character_details"){
                            CharacterDetailsScreen(
                                id = 173,
                                modifier = Modifier.padding(innerPadding)
                            ){
                                navController.navigate("character_episodes/$it")
                            }
                        }
                        composable("character_episodes/{characterId}") {
                            val characterId = it.arguments?.getString("characterId")
                            CharacterEpisodeScreen(
                                characterId = characterId?.toInt() ?: 0
                            )
                        }
                    }
                }
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