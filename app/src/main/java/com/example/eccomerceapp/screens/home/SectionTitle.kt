package com.example.eccomerceapp.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.eccomerceapp.ui.theme.PrimaryColor

@Composable
fun SectionTitle(title: String, actionText: String, onActionPressed: () -> Unit){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {
        Text(
            title,
            style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
        )
        )

        Text(
            actionText,
            style = MaterialTheme.typography.bodyMedium.copy(
            color = PrimaryColor
        ),
            modifier = Modifier.clickable {
                onActionPressed()
            }
        )
    }
}