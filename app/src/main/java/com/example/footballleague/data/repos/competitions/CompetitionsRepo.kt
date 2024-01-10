package com.example.footballleague.data.repos.competitions

import com.example.footballleague.data.DataStatus
import com.example.footballleague.data.models.CompetitionDetails
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepo {
    suspend fun getAllCompetitions(): Flow<DataStatus<List<CompetitionDetails>>>
}