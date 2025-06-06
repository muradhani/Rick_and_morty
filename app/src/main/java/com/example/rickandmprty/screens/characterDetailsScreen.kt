package com.example.rickandmprty.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.rickandmprty.components.CharacterImage
import com.example.rickandmprty.components.CharacterInfoSection
import com.example.rickandmprty.components.CharacterName
import com.example.rickandmprty.components.CharacterStatusComponent
import com.example.rickandmprty.components.TitleAndSubtitle
import com.example.rickandmprty.components.buildCharacterInfoItems
import com.example.rickandmprty.ui.theme.RickAction
import com.example.rickandmprty.ui.theme.RickPrimary
import com.example.rickandmprty.viewmodels.CharacterDetailsScreenViewModel


@Composable
fun CharacterDetailsScreen(
    id: Int,
    modifier: Modifier = Modifier,
    viewModel: CharacterDetailsScreenViewModel = hiltViewModel(),
    onEpisodeClick: () -> Unit,
){
    val character = viewModel.userData.collectAsStateWithLifecycle().value

    LaunchedEffect(id) {
        viewModel.getCharacterDetails(id)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = RickPrimary
    ) {
    character?.let {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {
            item {
                CharacterStatusComponent(character.status)
            }
            item {
                CharacterName(
                    name = character.name,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item {
                CharacterImage(
                    url = character.image
                )
            }
            item{
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                CharacterInfoSection(
                    items = buildCharacterInfoItems(character),
                    modifier = Modifier
                )
            }
            item{
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, RickAction),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = RickAction
                    ),
                    onClick = {
                        onEpisodeClick()
                    }
                ) {
                    Text(text = "View all episodes", color = RickAction , fontSize = 15.sp)
                }
            }
        }
    }
    }
}