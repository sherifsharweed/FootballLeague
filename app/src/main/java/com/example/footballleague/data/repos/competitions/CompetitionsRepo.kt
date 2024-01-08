package com.example.footballleague.data.repos.competitions

import com.example.footballleague.data.DataStatus
import com.example.footballleague.data.models.CompetitionResponse
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepo {
    suspend fun getAllCompetitions(): Flow<DataStatus<CompetitionResponse>>
}