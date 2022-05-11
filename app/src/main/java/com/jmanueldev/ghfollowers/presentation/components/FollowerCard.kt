package com.jmanueldev.ghfollowers.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jmanueldev.ghfollowers.R
import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.domain.utils.loadImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FollowerCard(
    onClick: () -> Unit,
    follower: GithubUser,
){
    Card(
        onClick = { onClick() },
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 10.dp)
        )
        {
            follower.avatarUrl?.let{
                val avatar = loadImage(url = it, placeHolderImage = R.drawable.avatar_placeholder).value
                avatar?.let {
                    Image(
                        bitmap = avatar.asImageBitmap(),
                        contentDescription = "Follower Avatar",
                        modifier = Modifier
                            .requiredSize(80.dp, 80.dp)
                            .clip(CircleShape)
                            .border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            Text(
                text = follower.username ?: "",
                fontSize = 14.sp,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .padding(bottom = 5.dp)
            )
        }
    }
}