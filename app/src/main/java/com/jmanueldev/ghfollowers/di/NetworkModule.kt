package com.jmanueldev.ghfollowers.di

import com.google.gson.GsonBuilder
import com.jmanueldev.ghfollowers.network.GithubService
import com.jmanueldev.ghfollowers.network.model.GithubUserDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideGithubUserMapper(): GithubUserDtoMapper{
        return GithubUserDtoMapper()
    }

    @Singleton
    @Provides
    fun provideGithubService(): GithubService {
        return Retrofit.Builder()
            .baseUrl(" https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(GithubService::class.java)
    }
}