package com.example.footballleague.data.repos.competitions

import com.example.footballleague.data.DataStatus
import com.example.footballleague.data.local.CompetitionsLocalDataSource
import com.example.footballleague.data.models.CompetitionDetails
import com.example.footballleague.data.models.mapCompetitionDetails
import com.example.footballleague.data.remote.CompetitionsRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CompetitionsRepoImpl @Inject constructor(
    private val remoteDataSource: CompetitionsRemoteDataSource,
    private val localDataSource: CompetitionsLocalDataSource
) :
    CompetitionsRepo {
    override suspend fun getAllCompetitions(): Flow<DataStatus<List<CompetitionDetails>>> {
        return flow {
            emit(DataStatus.loading())
            remoteDataSource.getAllCompetitions().let { response ->
                if (response.isSuccessful) {
                    response.body()?.competitions?.mapCompetitionDetails()?.let { list ->
                        localDataSource.addCompetitions(list)
                        emit(DataStatus.success(list))
                    }
                }
            }
        }.catch {
            emit(DataStatus.error("No Internet Connection"))
            emit(DataStatus.success(localDataSource.getAllCompetitions()))
        }.flowOn(Dispatchers.IO)
    }
}