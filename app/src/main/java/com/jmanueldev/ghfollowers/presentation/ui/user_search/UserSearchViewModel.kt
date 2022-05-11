package com.jmanueldev.ghfollowers.presentation.ui.user_search

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
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
    var user : MutableLiveData<GithubUser?> = MutableLiveData()

    fun onUserNameQueryChange(username: String){
        this.username.value = username
    }

    fun getUser(){
        viewModelScope.launch {
            val results = repository.getUser(username.value)
            user.value = results
        }
    }
}