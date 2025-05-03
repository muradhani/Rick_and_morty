package com.example.rickandmprty.components

import android.R
import android.view.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmprty.ui.theme.RickAction

@Composable
fun TitleAndSubtitle(
    title : String,
    subTitle : String,
    titleColor: Color = RickAction,
    subtitleColor : Color = Color.White,
    isEpisodeNameAndAirTime : Boolean = false,
    alignEnd : Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = title,
            style = if(isEpisodeNameAndAirTime) MaterialTheme.typography.headlineSmall else MaterialTheme.typography.bodyMedium ,
            color = titleColor,
            textAlign = if (alignEnd) TextAlign.End else TextAlign.Start
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = subTitle,
            style = if(isEpisodeNameAndAirTime) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.headlineSmall ,
            color = subtitleColor,
            textAlign = if (alignEnd) TextAlign.End else TextAlign.Start
        )
    }
}

@Preview(showBackground = false, name = "Title and Subtitle Preview")
@Composable
fun PreviewTitleAndSubtitle() {
    MaterialTheme {
        androidx.compose.material3.Surface(color = Color.Black) {
            TitleAndSubtitle(
                title = "Character Name",
                subTitle = "Interdimensional Traveler"
            )
        }
    }
}
