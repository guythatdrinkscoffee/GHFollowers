package com.jmanueldev.ghfollowers.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.jmanueldev.ghfollowers.R
import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.presentation.ui.user_search_fragment.UserSearchViewModel


@Composable
fun SearchScreen(
    searchViewModel: UserSearchViewModel = viewModel(),
    focusManager: FocusManager = LocalFocusManager.current,
    onSearch: () -> Unit
) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.gh_logo),
                contentDescription = "GitHub Logo",
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
                    .requiredSize(200.dp, 200.dp)

            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .padding(8.dp),
                value = searchViewModel.username.value,
                onValueChange = {
                    searchViewModel.onUserNameQueryChange(it)
                },
                label = {
                    Text("Username")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                   onDone = {
                       focusManager.clearFocus()
                   }
                )
            )

            Spacer(
                modifier = Modifier
                    .height(50.dp)
            )

            Button(
                onClick = {
                    onSearch()
                },
                enabled = searchViewModel.username.value.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
            ) {
                Text("Get Followers")
            }
        }
}