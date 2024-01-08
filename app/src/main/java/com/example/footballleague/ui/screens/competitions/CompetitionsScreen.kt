package com.example.footballleague.ui.screens.competitions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.footballleague.R
import com.example.footballleague.data.Status
import com.example.footballleague.data.models.CompetitionResponse
import com.example.footballleague.ui.components.LoadingBar
import com.example.footballleague.ui.components.ShowToast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllMatchesScreen(
    competitionsViewModel: CompetitionsViewModel = hiltViewModel(),
    onClickSingleMatch: () -> Unit = {},
) {
    Scaffold() { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            competitionsViewModel.screenState.value.let {
                when (it.status) {
                    Status.LOADING -> LoadingBar()
                    Status.SUCCESS -> CompetitionList(it.data)
                    Status.FAILURE -> ShowToast(message = it.message)
                }
            }
        }

    }
}

@Composable
fun CompetitionList(data: CompetitionResponse?) {
    if (data?.competitions?.isNotEmpty() == true) {
        LazyColumn(modifier = Modifier.padding(top = 4.dp)) {
            items(data.competitions.size) { index ->
                Text(text = data.competitions[index].name ?: "")
                Divider(Modifier.padding(vertical = 8.dp))
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(id = R.string.empty_data))
        }
    }
}
