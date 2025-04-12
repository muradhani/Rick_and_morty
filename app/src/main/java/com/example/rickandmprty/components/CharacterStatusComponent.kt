package com.example.rickandmprty.components

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ModalBottomSheet
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
    Row(
        modifier = Modifier.width(IntrinsicSize.Min)
            .border(width = 1.dp, color = androidx.compose.ui.graphics.Color(characterStatus.color), shape = RoundedCornerShape(12.dp))
            .background(color = androidx.compose.ui.graphics.Color(Color.TRANSPARENT), shape = RoundedCornerShape(12.dp))
            .padding(top = 8.dp, bottom = 8.dp, start = 10.dp, end = 10.dp)
    ) {
        Text(text = "Status: ", fontSize = 14.sp , modifier = Modifier.width(IntrinsicSize.Min))
        Text(modifier = Modifier.width(IntrinsicSize.Min),text = characterStatus.displayName, fontSize = 14.sp, fontWeight = FontWeight.Bold)
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