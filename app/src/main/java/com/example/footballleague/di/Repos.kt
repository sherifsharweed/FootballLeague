package com.example.footballleague.di

import com.example.footballleague.data.remote.CompetitionsRemoteDataSource
import com.example.footballleague.data.repos.competitions.CompetitionsRepo
import com.example.footballleague.data.repos.competitions.CompetitionsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Repos {
    @Provides
    fun provideCompetitionRepo(
        remoteDataSource: CompetitionsRemoteDataSource,
    ): CompetitionsRepo {
        return CompetitionsRepoImpl(remoteDataSource)
    }
}