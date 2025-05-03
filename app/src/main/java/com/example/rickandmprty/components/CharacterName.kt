package com.example.rickandmprty.components


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.example.rickandmprty.ui.theme.RickAction

@Composable
fun CharacterName(modifier: Modifier = Modifier, name : String) {
    Text(
        modifier = modifier,
        text = name,
        style = MaterialTheme.typography.headlineLarge,
        color = RickAction
    )
}

@Preview(showBackground = true, name = "Character Name Preview")
@Composable
fun PreviewCharacterName() {
    MaterialTheme {
        CharacterName(name = "Rick Sanchez")
    }
}