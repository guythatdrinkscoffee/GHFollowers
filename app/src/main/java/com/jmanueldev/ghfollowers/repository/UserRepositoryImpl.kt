package com.jmanueldev.ghfollowers.repository

import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.network.model.GithubUserDtoMapper
import com.jmanueldev.ghfollowers.network.GithubService

class UserRepositoryImpl
constructor(
    private val githubService: GithubService,
    private val dtoMapper: GithubUserDtoMapper
) : UserRepository{
    override suspend fun getUser(username: String): GithubUser {
        return dtoMapper.toDomainModel(githubService.getUser(username))
    }

    override suspend fun getFollowers(username: String): List<GithubUser> {
        return dtoMapper.toDomainModelList(githubService.getFollowers(username = username))
    }
}