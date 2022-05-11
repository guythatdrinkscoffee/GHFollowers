package com.jmanueldev.ghfollowers.repository

import com.jmanueldev.ghfollowers.domain.model.GithubUser

interface UserRepository {
    suspend fun getUser(username: String): GithubUser
    suspend fun getFollowers(username: String): List<GithubUser>
}