package com.example.rickandmprty.screens

import android.graphics.Color.TRANSPARENT
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.domain.modules.Character
import com.example.domain.modules.Character.Location
import com.example.domain.modules.Character.Origin
import com.example.domain.modules.CharacterGender
import com.example.domain.modules.CharacterStatus
import com.example.rickandmprty.components.CharacterStatusComponent
import com.example.rickandmprty.ui.theme.RickAction

import com.example.rickandmprty.ui.theme.RickPrimary
import com.example.rickandmprty.ui.theme.RickTextPrimary

@Composable
fun CharacterDetailsScreen(
character: Character
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = RickPrimary)
            .padding(horizontal = 15.dp)
    ) {
        item {
            CharacterStatusComponent(character.status)
        }
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

        item {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(12.dp)),
                model = character.url,
                contentDescription = null
            )
        }
        item{
            TitleAndSubtitle("Last Known Location" , character.location.name)
        }
        item{
            TitleAndSubtitle("Species" , character.species)
        }
        item{
            TitleAndSubtitle("Gender" , character.gender.displayName)
        }
        item{
            TitleAndSubtitle("Origin" , character.origin.name)
        }
        item{
            TitleAndSubtitle("Episode count" , character.episode.count().toString())
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
                onClick = { }
            ) {
                Text(text = "View all episodes", color = RickAction , fontSize = 15.sp)
            }
        }
    }
}

@Composable
fun TitleAndSubtitle(
    title : String,
    subTitle : String
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = RickAction
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = subTitle,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAliveStatus() {
    CharacterDetailsScreen(
        Character(
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