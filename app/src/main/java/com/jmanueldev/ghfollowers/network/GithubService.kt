package com.jmanueldev.ghfollowers.network

import com.jmanueldev.ghfollowers.network.model.GithubUserDto
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {
    @GET("users/{username}")
    suspend fun getFollowers(@Path("username") username: String): GithubUserDto
}