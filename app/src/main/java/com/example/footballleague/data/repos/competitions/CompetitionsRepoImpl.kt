package com.example.footballleague.data.repos.competitions

import com.example.footballleague.data.DataStatus
import com.example.footballleague.data.models.CompetitionResponse
import com.example.footballleague.data.remote.CompetitionsRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CompetitionsRepoImpl @Inject constructor(private val remoteDataSource: CompetitionsRemoteDataSource) :
    CompetitionsRepo {
    override suspend fun getAllCompetitions(): Flow<DataStatus<CompetitionResponse>> {
        return flow {
            emit(DataStatus.loading())
            val response = remoteDataSource.getAllCompetitions()
            if (response.isSuccessful) {
                emit(DataStatus.success(response.body()))
            } else {
                emit(DataStatus.error("error request"))
            }
        }.catch {
            emit(DataStatus.error(it.message))
        }.flowOn(Dispatchers.IO)
    }
}