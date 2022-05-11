package com.jmanueldev.ghfollowers.presentation.ui.user_search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jmanueldev.ghfollowers.R
import com.jmanueldev.ghfollowers.presentation.components.SearchScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserSearchFragment : Fragment() {
    //UserSearchViewModel
    val userSearchViewModel: UserSearchViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                SearchScreen()
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        userSearchViewModel.user.observe(viewLifecycleOwner) { user ->
            //if the user is not null then navigate to the followers screen. :D
            user?.let { githubUser ->
                val bundle = Bundle()
                bundle.putString("username", githubUser.username)
                navController.navigate(R.id.viewFollowers, bundle)
            }
        }
    }
}