package com.example.footballleague.ui.screens.competitions

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballleague.data.DataStatus
import com.example.footballleague.data.models.CompetitionDetails
import com.example.footballleague.data.repos.competitions.CompetitionsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CompetitionsViewModel @Inject constructor(private val competitionsRepo: CompetitionsRepo) :
    ViewModel() {
    val screenState = mutableStateOf<DataStatus<List<CompetitionDetails>>>(DataStatus.loading())

    init {
        getAllCompetitions()
    }

    private fun getAllCompetitions() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                competitionsRepo.getAllCompetitions().collect {
                    withContext(Dispatchers.Main) {
                        screenState.value = it
                    }
                }
            }
        }
    }
}

