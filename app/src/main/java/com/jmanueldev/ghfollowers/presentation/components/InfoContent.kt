package com.jmanueldev.ghfollowers.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun InfoContent(
    icon: ImageVector,
    title: String,
    subtitle: String,
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row{
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 2.dp)
            )
            Text(
                text = title
            )
        }
        Text(
            text = subtitle
        )
    }
}
