package com.jmanueldev.ghfollowers.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jmanueldev.ghfollowers.R
import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.domain.utils.loadImage

@Composable
fun FollowerHeader(
    follower: GithubUser
){
    Column{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            val avatar = loadImage(url = follower.avatarUrl?: "", placeHolderImage = R.drawable.avatar_placeholder).value
            avatar?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    text = follower.username ?: "",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(2.dp)
                )

                Text(
                    text = follower.name ?: "",
                    modifier = Modifier
                        .padding(5.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(5.dp)
                ){
                    Icon(imageVector = Icons.Filled.Place, contentDescription = "Location Icon")
                    Text(
                        text = follower.location ?: "N/A"
                    )
                }
            }
        }

        Text(
            text = follower.bio ?: "No bio available.",
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
    }
}
