package com.example.footballleague.data.remote.api

import com.example.footballleague.data.models.CompetitionResponse
import retrofit2.Response
import retrofit2.http.GET

interface CompetitionApiService {
    @GET(ALL_Competitions)
    suspend fun getAllCompetitions(): Response<CompetitionResponse>
}