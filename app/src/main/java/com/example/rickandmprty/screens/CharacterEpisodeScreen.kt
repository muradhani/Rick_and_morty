package com.example.rickandmprty.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.domain.modules.Episode
import com.example.rickandmprty.components.CharacterImage
import com.example.rickandmprty.components.CharacterName
import com.example.rickandmprty.components.TitleAndSubtitle
import com.example.rickandmprty.ui.theme.RickAction
import com.example.rickandmprty.ui.theme.RickPrimary
import com.example.rickandmprty.ui.theme.RickTextPrimary
import com.example.rickandmprty.viewmodels.CharacterDetailsScreenViewModel
import com.example.rickandmprty.viewmodels.EpisodesScreenViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterEpisodeScreen(
    modifier: Modifier,
    characterViewModel: CharacterDetailsScreenViewModel
) {
    val character = characterViewModel.userData.collectAsStateWithLifecycle().value
    val viewModel: EpisodesScreenViewModel = hiltViewModel()
    LaunchedEffect(character?.episode) { character?.let { viewModel.getEpisodes(it.episode) } }
    val episodes = viewModel.episodes.collectAsStateWithLifecycle().value
    val episodeBySeasonMap = remember(episodes) {
        episodes?.groupBy { it.seasonNumber }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = RickPrimary
    ) {
        character?.let {
            LazyColumn (
                    modifier = modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp)
                    ) {
                item {
                    CharacterName(
                        name = character.name,
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 10.dp),
                    )
                }
                item{
                    LazyRow {
                        episodeBySeasonMap?.forEach {
                            val title = "Season ${it.key}"
                            val description = "${it.value.size} ep"
                            item{TitleAndSubtitle(title = title, subTitle = description)}
                            item { Spacer(modifier = Modifier.width(20.dp)) }
                        }
                    }
                }
                item {
                    CharacterImage(
                        url = character.image
                    )
                }
                episodes?.let {
                    episodeBySeasonMap?.forEach { episode ->
                        item { Spacer(modifier = Modifier.height(30.dp)) }
                        stickyHeader { SeasonHeader(seasonNumber = episode.key) }
                        items(episode.value) { episode ->
                            EpisodeRow(episode = episode)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EpisodeRow(episode: Episode) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            TitleAndSubtitle(title = "Episode", subTitle = episode.episodeNumber, isEpisodeNameAndAirTime = false)
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            TitleAndSubtitle(
                title = episode.name,
                subTitle = episode.airDate,
                titleColor = RickTextPrimary,
                subtitleColor = RickTextPrimary,
                isEpisodeNameAndAirTime = true,
                alignEnd = true
            )
        }
    }
}

@Composable
fun SeasonHeader(seasonNumber: Int) {
    Text(
        text = "Season $seasonNumber",
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.fillMaxWidth().border(
            width = 1.dp,
            color = RickTextPrimary,
            shape = RoundedCornerShape(8.dp)
        ).padding(vertical = 8.dp),
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        color = RickTextPrimary
    )

}