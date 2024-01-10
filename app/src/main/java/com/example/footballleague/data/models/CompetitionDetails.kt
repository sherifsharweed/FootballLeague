package com.example.footballleague.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.footballleague.data.models.response.Competitions
import java.io.Serializable

@Entity
data class CompetitionDetails(
    @PrimaryKey var id: Int? ,
    var areaName: String? = null,
    var areaFlag: String? = null,
    var name: String? = null,
    var code: String? = null,
    var type: String? = null,
    var emblem: String? = null,
    var plan: String? = null,
    var startDate: String? = null,
    var endDate: String? = null,
    var currentMatchDay: Int? = null,
    var numberOfAvailableSeasons: Int? = null,
    var lastUpdated: String? = null
) : Serializable


fun ArrayList<Competitions>.mapCompetitionDetails(): List<CompetitionDetails> {
    return map {
        CompetitionDetails(
            id = it.id,
            areaName = it.area?.name,
            areaFlag = it.area?.flag,
            name = it.name,
            code = it.code,
            type = it.type,
            emblem = it.emblem,
            plan = it.plan,
            startDate = it.currentSeason?.startDate,
            endDate = it.currentSeason?.endDate,
            currentMatchDay = it.currentSeason?.currentMatchDay,
            numberOfAvailableSeasons = it.numberOfAvailableSeasons,
            lastUpdated = it.lastUpdated
        )
    }
}