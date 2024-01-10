package com.example.footballleague.ui.screens.competitions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballleague.R
import com.example.footballleague.data.Status
import com.example.footballleague.ui.components.LoadingBar
import com.example.footballleague.ui.components.ShowToast
import com.example.footballleague.ui.screens.competitions.comonents.CompetitionList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllMatchesScreen(
    competitionsViewModel: CompetitionsViewModel = hiltViewModel(),
    onClickSingleMatch: () -> Unit = {},
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(stringResource(R.string.football_league)) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
            )
        )
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            competitionsViewModel.screenState.value.let {
                when (it.status) {
                    Status.LOADING -> LoadingBar()
                    Status.SUCCESS -> CompetitionList(it.data)
                    Status.FAILURE -> ShowToast(it.message)
                }
            }
        }

    }
}


