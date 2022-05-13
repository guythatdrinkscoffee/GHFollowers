package com.jmanueldev.ghfollowers.presentation.ui.user_followers_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jmanueldev.ghfollowers.presentation.components.FollowerScreen

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
        val navController = findNavController()

        return ComposeView(requireContext()).apply {
            setContent {
                FollowerScreen( navController = navController)
            }
        }
    }

}
