package com.example.footballleague.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footballleague.data.models.CompetitionDetails

@Database(entities = [CompetitionDetails::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun competitionsDao() : CompetitionsDao
}