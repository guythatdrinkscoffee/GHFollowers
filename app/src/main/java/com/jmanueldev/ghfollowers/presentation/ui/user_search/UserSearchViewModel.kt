package com.jmanueldev.ghfollowers.presentation.ui.user_search

import android.util.Log
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
class UserSearchViewModel
@Inject
constructor(
    private val repository: UserRepository
): ViewModel() {
    val username = mutableStateOf("")
    var user: MutableState<GithubUser?> = mutableStateOf(null)
    val isSearching = mutableStateOf(false)

    fun getUser(){
        viewModelScope.launch {
            isSearching.value = true
            delay(5000)
            val result = repository.getUser(username = username.value)
            user.value = result
            isSearching.value = false
        }
    }

    fun onUserNameQueryChange(username: String){
        this.username.value = username
    }
}