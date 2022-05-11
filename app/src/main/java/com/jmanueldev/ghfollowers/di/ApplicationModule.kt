package com.jmanueldev.ghfollowers.di

import android.content.Context
import com.jmanueldev.ghfollowers.presentation.GHFollowersApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideApp(@ApplicationContext app: Context): GHFollowersApplication{
        return app as GHFollowersApplication
    }
}