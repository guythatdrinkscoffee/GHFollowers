package com.jmanueldev.ghfollowers.network.model

import com.jmanueldev.ghfollowers.domain.model.GithubUser
import com.jmanueldev.ghfollowers.domain.model.utils.DomainMapper

class GithubUserDtoMapper: DomainMapper<GithubUserDto, GithubUser>{
    override fun toDomainModel(model: GithubUserDto): GithubUser {
        return GithubUser(
            username = model.login
        )
    }
}