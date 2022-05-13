package com.jmanueldev.ghfollowers.presentation.ui.user_search_fragment

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
                SearchScreen(
                    onSearch = {
                        val bundle = Bundle()
                        bundle.putString("username", userSearchViewModel.username.value)
                        findNavController().navigate(R.id.viewFollowers, bundle)
                        userSearchViewModel.clearSearch()
                    }
                )
            }
        }
    }

}