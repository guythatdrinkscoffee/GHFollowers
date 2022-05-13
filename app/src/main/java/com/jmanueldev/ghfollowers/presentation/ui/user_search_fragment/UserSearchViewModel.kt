package com.jmanueldev.ghfollowers.presentation.ui.user_search_fragment

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSearchViewModel
@Inject
constructor(
    private val repository: UserRepository
): ViewModel() {
    val username = mutableStateOf("")

    fun onUserNameQueryChange(username: String){
        this.username.value = username
    }

    fun clearSearch(){
        username.value = ""
    }
}