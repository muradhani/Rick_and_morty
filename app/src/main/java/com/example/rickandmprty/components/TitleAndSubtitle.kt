package com.example.rickandmprty.components

import android.view.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmprty.ui.theme.RickAction

@Composable
fun TitleAndSubtitle(
    title : String,
    subTitle : String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
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
