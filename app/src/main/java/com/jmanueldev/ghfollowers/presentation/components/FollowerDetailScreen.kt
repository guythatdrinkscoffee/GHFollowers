package com.jmanueldev.ghfollowers.presentation.components

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.jmanueldev.ghfollowers.R
import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.domain.utils.loadImage
import com.jmanueldev.ghfollowers.presentation.ui.follower_fragment.FollowerViewModel
import java.lang.String.format
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun FollowerDetailScreen(
    followerViewModel: FollowerViewModel = viewModel(),
    onNavigate: (GithubUser) -> Unit
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

            InfoCard(buttonTitle = "Github Profile", onButtonClick = {
                onNavigate(follower)
            }
            ) {
                InfoContent(icon = Icons.Filled.Create , title = "Public Repos" , subtitle = follower.repos.toString())
                InfoContent(icon = Icons.Filled.Menu, title = "Public Gists", subtitle = follower.gists.toString())
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            InfoCard(
                buttonTitle = "Get Followers",
                onButtonClick = {
                    onNavigate(follower)
                }
            ) {
                InfoContent(icon = Icons.Filled.Face, title = "Followers", subtitle = follower.followers.toString())
                InfoContent(icon = Icons.Filled.Person, title = "Following", subtitle = follower.following.toString())
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "GitHub Since ${toRelativeTime(follower.createdAt ?: " ")}"
            )

            toRelativeTime(follower.createdAt ?: " ")
        }
    }
}

@SuppressLint("SimpleDateFormat")
fun toRelativeTime(dateString: String) : String? {
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    try {
        val date = format.parse(dateString)
        date?.let {
            val shortDate = SimpleDateFormat.getDateInstance(DateFormat.MEDIUM).format(it)
            return shortDate
        }
        return null
    } catch (e: ParseException){
        e.printStackTrace()
    }
    return "Unknown"
}



