package com.jmanueldev.ghfollowers.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val username: String?,
    val avatarUrl: String?,
    val bio: String?,
    val name: String?,
    val location: String?,
    val repos: Int,
    val gists: Int,
    val createdAt: String?,
    val followers: Int,
    val following: Int
): Parcelable
