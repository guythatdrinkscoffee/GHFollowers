package com.jmanueldev.ghfollowers.presentation.ui.user_followers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jmanueldev.ghfollowers.presentation.components.FollowerScreen
import com.jmanueldev.ghfollowers.presentation.components.LoadingIndicator
import com.jmanueldev.ghfollowers.presentation.components.VerticalGrid

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FollowersFragment : Fragment(){
    private val followersViewModel: FollowersViewModel by viewModels()
    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("username")?.let { userName ->
            this.userName = userName
            followersViewModel.getFollowers(username = userName)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                FollowerScreen()
            }
        }
    }
}
