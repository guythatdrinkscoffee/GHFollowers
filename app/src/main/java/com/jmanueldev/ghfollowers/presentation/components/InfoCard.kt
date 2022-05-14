package com.jmanueldev.ghfollowers.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun InfoCard(
    buttonTitle: String,
    onButtonClick: () -> Unit,
    content: @Composable () -> Unit,
){
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth(0.95F  )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9F)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                content()
            }

            Button(
                onClick = { onButtonClick() },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(5.dp)
            ) {
                Text(
                    text = buttonTitle
                )
            }
        }

    }
}
