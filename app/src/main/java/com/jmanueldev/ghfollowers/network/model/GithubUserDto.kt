package com.jmanueldev.ghfollowers.network.model

import com.google.gson.annotations.SerializedName

data class GithubUserDto(
    @SerializedName("login")
    val login: String?,

    @SerializedName("avatar_url")
    val avatarUrl: String?,

    @SerializedName("html_url")
    val htmlUrl: String?,

    @SerializedName("followers_url")
    val followersUrl: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("location")
    val location: String?,

    @SerializedName("public_repos")
    val repos: Int,

    @SerializedName("public_gists")
    val gists: Int,

    @SerializedName("followers")
    val followers: Int,

    @SerializedName("created_at")
    val createdAt: String,
)