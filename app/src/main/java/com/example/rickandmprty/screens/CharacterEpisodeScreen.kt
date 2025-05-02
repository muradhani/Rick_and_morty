package com.example.rickandmprty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.domain.modules.Episode
import com.example.rickandmprty.ui.theme.RickAction
import com.example.rickandmprty.ui.theme.RickPrimary
import com.example.rickandmprty.viewmodels.CharacterDetailsScreenViewModel
import com.example.rickandmprty.viewmodels.EpisodesScreenViewModel


@Composable
fun CharacterEpisodeScreen(
    characterViewModel: CharacterDetailsScreenViewModel
) {
    val character = characterViewModel.userData.collectAsStateWithLifecycle().value
    val viewModel: EpisodesScreenViewModel = hiltViewModel()
    character?.let { viewModel.getEpisodes(it.episode)}
        val episodes = viewModel.episodes.collectAsStateWithLifecycle().value
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = RickPrimary
    ) {
        character?.let {
            LazyColumn {
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        text = character.name,
                        style = MaterialTheme.typography.headlineLarge,
                        color = RickAction
                    )
                }
                item { Spacer(modifier = Modifier.height(16.dp)) }
                item {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(12.dp)),
                        model = character.image,
                        contentDescription = null
                    )
                }
                episodes?.let {
                    items(episodes) { episode ->
                        EpisodeRow(episode = episode)
                    }
                }
            }
        }
    }
}

@Composable
fun EpisodeRow(episode: Episode) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Episode")
            Text(text = episode.episodeNumber)
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            Text(text = episode.name)
            Text(text = episode.airDate)
        }
    }
}
