package com.example.footballleague.ui.screens.competitions.comonents


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.footballleague.R
import com.example.footballleague.data.models.CompetitionResponse
import com.example.footballleague.data.models.Competitions
import com.example.footballleague.ui.theme.MainTextStyle

@Composable
fun CompetitionList(data: CompetitionResponse?) {
    if (data?.competitions?.isNotEmpty() == true) {
        LazyColumn(modifier = Modifier.padding(top = 4.dp)) {
            items(data.competitions.size) { index ->
                CompetitionListItem(data.competitions[index]) {}
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

@Composable
fun CompetitionListItem(competitions: Competitions, onItemSelect: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable(onClick = { }),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = competitions.name!!,
                maxLines = 1,
                style = MainTextStyle
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = competitions.area?.name ?: "",
                    maxLines = 1,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.width(5.dp))
                DrawUrlImage(competitions.area?.flag, Modifier.size(15.dp, 10.dp))
            }
        }
        Spacer(Modifier.weight(1f))
        DrawUrlImage(competitions.emblem, Modifier.size(30.dp))
    }
}