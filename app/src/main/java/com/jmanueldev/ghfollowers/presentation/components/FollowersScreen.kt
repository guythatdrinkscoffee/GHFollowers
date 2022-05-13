package com.jmanueldev.ghfollowers.presentation.components

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.jmanueldev.ghfollowers.R
import com.jmanueldev.ghfollowers.presentation.ui.user_followers_fragment.FollowersViewModel

@Composable
fun FollowerScreen(
    followersViewModel: FollowersViewModel = viewModel(),
    navController: NavController
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box{
            VerticalGrid( data = followersViewModel.followers.value) { follower ->
                //Handler user card click
                val bundle = Bundle()
                bundle.putString("follower_username", follower.username)
                navController.navigate(R.id.followerFragment, bundle)
            }

            LoadingIndicator(isVisible = followersViewModel.isLoading.value)
        }
    }
}