package com.example.footballleague.data.local

import com.example.footballleague.data.models.CompetitionDetails

interface CompetitionsLocalDataSource {
    suspend fun addCompetitions(competitions: List<CompetitionDetails>)

    suspend fun getAllCompetitions(): List<CompetitionDetails>
}