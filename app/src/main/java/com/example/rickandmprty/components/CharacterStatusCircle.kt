package com.example.rickandmprty.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.modules.CharacterStatus

@Composable
fun CharacterStatusCircle(modifier: Modifier = Modifier,status: CharacterStatus) {
    Box(
        modifier = modifier.background(
            brush = Brush.radialGradient(listOf(Color.Black,Color.Transparent)),
            shape = CircleShape
        ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.padding(all = 6.dp)
                .size(12.dp)
                .background(color = Color(status.color), shape = CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterStatusCircle() {
    CharacterStatusCircle(
        modifier = Modifier.size(40.dp),
        status = CharacterStatus.Alive // Replace with an actual status from your enum/sealed class
    )
}