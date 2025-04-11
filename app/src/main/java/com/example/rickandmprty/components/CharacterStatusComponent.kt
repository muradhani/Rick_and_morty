package com.example.rickandmprty.components

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.modules.CharacterStatus

@Composable
fun CharacterStatusComponent(characterStatus: CharacterStatus) {
    Column(
        modifier = Modifier.width(IntrinsicSize.Min)

            .border(width = 2.dp, color = androidx.compose.ui.graphics.Color(characterStatus.color), shape = RoundedCornerShape(12.dp))
            .background(color = androidx.compose.ui.graphics.Color(Color.LTGRAY), shape = RoundedCornerShape(12.dp))
            .padding(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 48.dp)
    ) {
        Text(text = "Status", fontSize = 14.sp)
        Text(text = characterStatus.displayName, fontSize = 24.sp, fontWeight = FontWeight.Bold)

    }

}

@Preview(showBackground = false)
@Composable
fun PreviewAliveStatus() {
    CharacterStatusComponent(characterStatus = CharacterStatus.Alive)
}

@Preview(showBackground = false)
@Composable
fun PreviewDeadStatus() {
    CharacterStatusComponent(characterStatus = CharacterStatus.Dead)
}

@Preview(showBackground = false)
@Composable
fun PreviewUnknownStatus() {
    CharacterStatusComponent(characterStatus = CharacterStatus.Unknown)
}