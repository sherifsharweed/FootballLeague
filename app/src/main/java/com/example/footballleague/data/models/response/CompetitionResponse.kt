package com.example.footballleague.data.models.response

import com.google.gson.annotations.SerializedName

data class CompetitionResponse(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("competitions") var competitions: ArrayList<Competitions> = arrayListOf()
)


data class Competitions(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("area") var area: Area? = Area(),
    @SerializedName("name") var name: String? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("emblem") var emblem: String? = null,
    @SerializedName("plan") var plan: String? = null,
    @SerializedName("currentSeason") var currentSeason: CurrentSeason? = CurrentSeason(),
    @SerializedName("numberOfAvailableSeasons") var numberOfAvailableSeasons: Int? = null,
    @SerializedName("lastUpdated") var lastUpdated: String? = null

)


data class Area(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("flag") var flag: String? = null

)

data class CurrentSeason(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("startDate") var startDate: String? = null,
    @SerializedName("endDate") var endDate: String? = null,
    @SerializedName("currentMatchday") var currentMatchDay: Int? = null,
    @SerializedName("winner") var winner: Winner? = Winner()

)

data class Winner(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("shortName") var shortName: String? = null,
    @SerializedName("tla") var tla: String? = null,
    @SerializedName("crest") var crest: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("website") var website: String? = null,
    @SerializedName("founded") var founded: Int? = null,
    @SerializedName("clubColors") var clubColors: String? = null,
    @SerializedName("venue") var venue: String? = null,
    @SerializedName("lastUpdated") var lastUpdated: String? = null

)