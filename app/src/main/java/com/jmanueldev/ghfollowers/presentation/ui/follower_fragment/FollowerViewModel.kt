package com.jmanueldev.ghfollowers.presentation.ui.follower_fragment

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowerViewModel
@Inject
constructor(
    private val repository: UserRepository
): ViewModel(){

    val user: MutableState<GithubUser?> = mutableStateOf(null)

    fun getFollower(username: String){
        viewModelScope.launch {
            val result = repository.getUser(username = username)
            user.value = result
        }
    }
}