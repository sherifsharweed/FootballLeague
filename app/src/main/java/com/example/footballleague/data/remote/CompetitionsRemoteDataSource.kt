package com.example.footballleague.data.remote

import com.example.footballleague.data.models.response.CompetitionResponse
import retrofit2.Response

interface CompetitionsRemoteDataSource {
    suspend fun getAllCompetitions(): Response<CompetitionResponse>
}