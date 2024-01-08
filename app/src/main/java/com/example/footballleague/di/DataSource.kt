package com.example.footballleague.di

import com.example.footballleague.data.remote.CompetitionsRemoteData
import com.example.footballleague.data.remote.CompetitionsRemoteDataSource
import com.example.footballleague.data.remote.api.CompetitionApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSource {
    @Provides
    fun provideCompetitionRemoteDataSource(
        reposApiService: CompetitionApiService,
    ): CompetitionsRemoteDataSource {
        return CompetitionsRemoteData(reposApiService)
    }
}