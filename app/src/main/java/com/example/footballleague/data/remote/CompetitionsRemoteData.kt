package com.example.footballleague.data.remote

import com.example.footballleague.data.models.response.CompetitionResponse
import com.example.footballleague.data.remote.api.CompetitionApiService
import retrofit2.Response
import javax.inject.Inject

class CompetitionsRemoteData @Inject constructor(private val competitionApiService: CompetitionApiService) :
    CompetitionsRemoteDataSource {
    override suspend fun getAllCompetitions(): Response<CompetitionResponse> {
        return competitionApiService.getAllCompetitions()
    }
}