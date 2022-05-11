package com.jmanueldev.ghfollowers.network

import com.jmanueldev.ghfollowers.network.model.GithubUserDto
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): GithubUserDto

    @GET("users/{username}/followers")
    suspend fun getFollowers(@Path("username") username: String): List<GithubUserDto>
}