package com.jmanueldev.ghfollowers.presentation.ui.user_followers_fragment

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FollowersViewModel
@Inject
constructor(
   private val repository: UserRepository
): ViewModel() {
    val followers: MutableState<List<GithubUser>> = mutableStateOf(listOf())
    val isLoading = mutableStateOf(false)

    fun getFollowers(username: String){
        viewModelScope.launch {
            isLoading.value = true
            delay(1000)
            val results = repository.getFollowers(username = username)
            followers.value = results

            isLoading.value = false
        }
    }
}