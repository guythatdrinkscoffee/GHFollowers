package com.jmanueldev.ghfollowers.di

import com.jmanueldev.ghfollowers.network.GithubService
import com.jmanueldev.ghfollowers.network.model.GithubUserDtoMapper
import com.jmanueldev.ghfollowers.repository.UserRepository
import com.jmanueldev.ghfollowers.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        githubService: GithubService,
        githubUserDtoMapper: GithubUserDtoMapper
    ): UserRepository {
        return UserRepositoryImpl(
            githubService,
            githubUserDtoMapper
        )
    }
}