package com.example.footballleague.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.footballleague.data.local.dao.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import java.nio.charset.StandardCharsets
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RoomDataBase {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): AppDataBase {
        // Add factory to encrypt data in local storage
        System.loadLibrary("sqlcipher")
        val password = "Password1!"
        val databaseFile = appContext.getDatabasePath("footballLeague")
        val factory = SupportOpenHelperFactory(password.toByteArray(StandardCharsets.UTF_8))
        return databaseBuilder(
            appContext, AppDataBase::class.java, databaseFile.absolutePath
        ).openHelperFactory(factory).build()
    }
}