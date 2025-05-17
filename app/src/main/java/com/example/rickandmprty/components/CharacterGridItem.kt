package com.example.rickandmprty.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType.Companion.Gender
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.modules.Character
import com.example.domain.modules.CharacterGender
import com.example.domain.modules.CharacterStatus
import com.example.rickandmprty.ui.theme.RickAction

@Composable
fun CharacterGridItem(modifier: Modifier = Modifier, character: Character) {
    Row (
        modifier = Modifier.height(140.dp).border(
            width = 1.dp,
            brush = Brush.horizontalGradient(listOf(Color.Transparent, RickAction)),
            shape = RoundedCornerShape(12.dp)
        )
    ) {
        Box {
            CharacterImage(
                url = character.image, modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(12.dp))
            )
            CharacterStatusCircle(
                modifier = Modifier.padding(top = 6.dp, start = 6.dp),
                status = character.status
            )
        }
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp),
            content = {
                items(items = buildCharacterInfoItems(character), key = { it.hashCode() }) {
                    Column(verticalArrangement = Arrangement.Center) {
                        TitleAndSubtitle(it.title, it.subtitle)
                    }
                }
            }
        )
    }
}



@Preview(showBackground = true)
@Composable
fun CharacterGridItemPreview() {
        CharacterGridItem(
            character = Character(
                id = 1,
                name = "Rick Sanchez",
                status = CharacterStatus.Alive, // assuming you have this enum
                species = "Human",
                type = "",
                gender = CharacterGender.Male, // assuming you have this enum
                origin = Character.Origin(name = "Earth", url = ""),
                location = Character.Location(name = "Earth", url = ""),
                image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                episode = emptyList(),
                url = "",
                created = ""
            ),
            modifier = Modifier.padding(8.dp)
        )
}
