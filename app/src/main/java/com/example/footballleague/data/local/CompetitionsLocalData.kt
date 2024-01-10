package com.example.footballleague.data.local

import com.example.footballleague.data.local.dao.AppDataBase
import com.example.footballleague.data.models.CompetitionDetails
import javax.inject.Inject

class CompetitionsLocalData @Inject constructor(private val appDataBase: AppDataBase) :
    CompetitionsLocalDataSource {
    override suspend fun addCompetitions(competitions: List<CompetitionDetails>) {
        return appDataBase.competitionsDao().addCompetitions(competitions)
    }

    override suspend fun getAllCompetitions(): List<CompetitionDetails> {
        return appDataBase.competitionsDao().getAllCompetitions()
    }
}