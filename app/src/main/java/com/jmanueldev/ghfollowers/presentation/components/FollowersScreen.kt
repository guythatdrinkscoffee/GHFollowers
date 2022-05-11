package com.jmanueldev.ghfollowers.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jmanueldev.ghfollowers.presentation.components.LoadingIndicator
import com.jmanueldev.ghfollowers.presentation.components.VerticalGrid
import com.jmanueldev.ghfollowers.presentation.ui.user_followers.FollowersViewModel

@Composable
fun FollowerScreen(
    followersViewModel: FollowersViewModel = viewModel(),
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box{
            VerticalGrid( data = followersViewModel.followers.value) { follower ->
                //Handler user card click
                Log.d("Followers", "$follower was clicked")
            }

            LoadingIndicator(isVisible = followersViewModel.isLoading.value)
        }
    }
}