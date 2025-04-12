package com.example.rickandmprty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            RickAndMprtyTheme {
                CharacterDetailsScreen(
                    character =    Character(
                        name = "Rick Sanchez",
                        url = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        species = "Human",
                        id = 1,
                        created = "2017-11-04T18:48:46.250Z",
                        status= CharacterStatus.Alive,
                        episode = listOf(),
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        type = "Human",
                        gender = CharacterGender.Male,
                        location = Location(
                            name = "Citadel of Ricks",
                            url = "https://rickandmortyapi.com/api/location/3"
                        ),
                        origin = Origin(
                            name = "Earth (C-137)",
                            url = "https://rickandmortyapi.com/api/location/1"
                        )
                    )
                )
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