package com.example.footballleague.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballleague.data.models.CompetitionDetails

@Dao
interface CompetitionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCompetitions(competitions: List<CompetitionDetails>)

    @Query("SELECT * FROM CompetitionDetails")
    fun getAllCompetitions(): List<CompetitionDetails>
}