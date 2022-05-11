package com.jmanueldev.ghfollowers.domain.utils

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

@SuppressLint("UnrememberedMutableState")
@Composable
fun loadImage(url: String, @DrawableRes placeHolderImage: Int): MutableState<Bitmap?> {
    val state: MutableState<Bitmap?> = mutableStateOf(null)
    val context = LocalContext.current

    Glide
        .with(context)
        .asBitmap()
        .load(placeHolderImage)
        .into(object: CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                state.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })

    Glide
        .with(context)
        .asBitmap()
        .load(url)
        .into(object: CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                state.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })

    return state
}
