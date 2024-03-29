package com.example.footballleague.ui.screens.competitions.components


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
import com.example.footballleague.data.models.CompetitionDetails
import com.example.footballleague.ui.theme.MainTextStyle

@Composable
fun CompetitionList(data: List<CompetitionDetails>?, onItemSelect: (CompetitionDetails) -> Unit) {
    if (data?.isNotEmpty() == true) {
        LazyColumn(modifier = Modifier.padding(top = 4.dp)) {
            items(data.size) { index ->
                CompetitionListItem(data[index], onItemSelect)
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
fun CompetitionListItem(
    competition: CompetitionDetails,
    onItemSelect: (CompetitionDetails) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable(onClick = { onItemSelect(competition) }),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = competition.name!!,
                maxLines = 1,
                style = MainTextStyle
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = competition.areaName ?: "",
                    maxLines = 1,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.width(5.dp))
                DrawUrlImage(competition.areaFlag, Modifier.size(15.dp, 10.dp))
            }
        }
        Spacer(Modifier.weight(1f))
        DrawUrlImage(competition.emblem, Modifier.size(30.dp))
    }
}