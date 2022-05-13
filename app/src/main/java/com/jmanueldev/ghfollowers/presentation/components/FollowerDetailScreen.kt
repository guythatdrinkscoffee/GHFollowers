package com.jmanueldev.ghfollowers.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jmanueldev.ghfollowers.R
import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.domain.utils.loadImage
import com.jmanueldev.ghfollowers.presentation.ui.follower_fragment.FollowerViewModel

@Composable
fun FollowerDetailScreen(
    followerViewModel: FollowerViewModel = viewModel()
){
    followerViewModel.user.value?.let { follower ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FollowerHeader(follower = follower)

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            InfoCard(buttonTitle = "Github Profile", onButtonClick = {  }) {
                InfoContent(icon = Icons.Filled.Create , title = "Public Repos" , subtitle = follower.repos.toString())
                InfoContent(icon = Icons.Filled.Menu, title = "Public Gists", subtitle = follower.gists.toString())
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            InfoCard(buttonTitle = "Get Followers", onButtonClick = {}) {
                InfoContent(icon = Icons.Filled.Face, title = "Followers", subtitle = follower.followers.toString())
                InfoContent(icon = Icons.Filled.Person, title = "Following", subtitle = follower.following.toString())
            }
        }
    }
}

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
