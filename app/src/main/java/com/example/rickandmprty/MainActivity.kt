package com.example.rickandmprty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmprty.screens.CharacterDetailsScreen
import com.example.rickandmprty.screens.CharacterEpisodeScreen
import com.example.rickandmprty.ui.theme.RickAndMprtyTheme
import com.example.rickandmprty.viewmodels.CharacterDetailsScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

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
                        composable("character_details"){ backStackEntry ->
                            val viewModel : CharacterDetailsScreenViewModel = hiltViewModel(backStackEntry)
                            CharacterDetailsScreen(
                                id = 175,
                                viewModel = viewModel,
                                modifier = Modifier.padding(innerPadding)
                            ){
                                navController.navigate("character_episodes")
                            }
                        }
                        composable("character_episodes") { backStackEntry ->
                            val viewModel : CharacterDetailsScreenViewModel = if (navController.previousBackStackEntry != null) hiltViewModel(
                                navController.previousBackStackEntry!!
                            ) else hiltViewModel()
                            CharacterEpisodeScreen(viewModel)
                        }
                    }
                }
            }
        }
    }
}