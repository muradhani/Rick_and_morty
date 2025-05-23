package com.example.rickandmprty.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.unit.dp
import com.example.rickandmprty.components.CharacterListItem


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    onCharacterClick : (Int) -> Unit
) {
    val characters = viewModel.characters.collectAsStateWithLifecycle().value
    val hasLoadedCharacters = rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(hasLoadedCharacters.value) {
        if (!hasLoadedCharacters.value) {
            viewModel.getCharacters(1)
            hasLoadedCharacters.value = true
        }
    }

    val scrollStateCharacters = rememberLazyGridState()

    LaunchedEffect(scrollStateCharacters) {
        snapshotFlow {
            val lastVisibleIndex = scrollStateCharacters.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            val totalItemsCount = scrollStateCharacters.layoutInfo.totalItemsCount
            lastVisibleIndex to totalItemsCount
        }.collect { (lastVisibleIndex, totalItemsCount) ->
            if (lastVisibleIndex >= totalItemsCount - 5 && totalItemsCount > 0) {
                viewModel.getNextCharactersPage()
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = RickPrimary
    ) {
        characters?.let { characters ->
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                state = scrollStateCharacters,
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(characters) { character ->
                    CharacterListItem(character = character , onClick = {
                        onCharacterClick(character.id)
                    })
                }
            }
        }
    }
}