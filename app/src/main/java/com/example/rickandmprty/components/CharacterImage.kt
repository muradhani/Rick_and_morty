package com.example.rickandmprty.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

val deafultModifier = Modifier
    .fillMaxWidth()
    .aspectRatio(1f)
    .clip(RoundedCornerShape(12.dp))
@Composable
fun CharacterImage(modifier: Modifier = deafultModifier,url:String) {
    AsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = null
    )
}