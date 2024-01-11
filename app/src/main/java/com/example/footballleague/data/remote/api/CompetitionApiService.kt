package com.example.footballleague.data.remote.api

import com.example.footballleague.data.models.response.CompetitionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CompetitionApiService {
    @Headers( "X-Auth-Token:$TOKEN" )
    @GET(ALL_Competitions)
    suspend fun getAllCompetitions(): Response<CompetitionResponse>
}