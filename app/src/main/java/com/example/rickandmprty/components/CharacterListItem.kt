package com.example.rickandmprty.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.modules.Character
import com.example.domain.modules.CharacterGender
import com.example.domain.modules.CharacterStatus
import com.example.rickandmprty.ui.theme.RickAction

@Composable
fun CharacterListItem(
    onClick: ()-> Unit,
    character: Character
) {
    Column(
        modifier = Modifier.border(
            width = 1.dp,
            brush = Brush.verticalGradient(listOf(Color.Transparent, RickAction)),
            shape = RoundedCornerShape(12.dp)
        )
            .clip(RoundedCornerShape(12.dp))
            .clickable{onClick}
    ) {
        Box{
            CharacterImage(url = character.image)
            CharacterStatusCircle(modifier = Modifier.padding(top = 6.dp, start = 6.dp),status = character.status)
        }
        Text(
            text = character.name,
            color = RickAction,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            lineHeight = 26.sp,
            modifier = Modifier.padding(all = 10.dp)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewCharacterListItem() {
    val mockCharacter = Character(
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
    )

    CharacterListItem(
        onClick = {},
        character = mockCharacter
    )
}