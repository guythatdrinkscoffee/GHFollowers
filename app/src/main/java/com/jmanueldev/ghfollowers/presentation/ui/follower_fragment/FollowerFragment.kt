package com.jmanueldev.ghfollowers.presentation.ui.follower_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.jmanueldev.ghfollowers.R
import com.jmanueldev.ghfollowers.presentation.components.FollowerDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FollowerFragment : Fragment(){

    private val followerViewModel: FollowerViewModel by viewModels()
    private lateinit var followerUsername: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("follower_username")?.let {
            followerUsername = it
            followerViewModel.getFollower(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                FollowerDetailScreen {
                    val bundle = Bundle()
                    bundle.putString("username", it.username)
                    findNavController().navigate(
                        R.id.action_followerFragment_to_userFollowersFragment2,
                        bundle
                    )
                }
            }
        }
    }
}