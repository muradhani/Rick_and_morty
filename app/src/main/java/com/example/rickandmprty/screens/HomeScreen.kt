package com.example.rickandmprty.screens


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.rickandmprty.ui.theme.RickPrimary
import com.example.rickandmprty.viewmodels.HomeScreenViewModel
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.grid.items
import com.example.rickandmprty.components.CharacterListItem


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val characters = viewModel.characters.collectAsStateWithLifecycle().value
    LaunchedEffect(key1 = viewModel, block = {viewModel.getCharacters(1)})
    val scrollStateCharacters = rememberLazyGridState()
    var loadNextPage = remember {
        derivedStateOf {
            val visibleItemPosition = scrollStateCharacters.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: return@derivedStateOf false
            val charactersCount = characters?.size ?: return@derivedStateOf false
            visibleItemPosition >= charactersCount - 10
        }
    }
    LaunchedEffect(key1 = loadNextPage, block = {
        if (loadNextPage.value) viewModel.getNextCharactersPage()
    })

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = RickPrimary
    ) {
        characters?.let { characters ->
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                state = scrollStateCharacters,
                columns = GridCells.Fixed(2),
            ){
                items(characters) { character ->
                    CharacterListItem(character = character , onClick = {})
                }
            }
        }
    }
}