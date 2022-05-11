package com.jmanueldev.ghfollowers.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun LoadingIndicator(
    isVisible: Boolean
) {
    if(isVisible){
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ){
            val indicator = createRef()
            CircularProgressIndicator(
                modifier = Modifier
                    .constrainAs(indicator){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}