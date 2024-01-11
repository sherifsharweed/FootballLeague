package com.example.footballleague.ui.screens.singleCompetiion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.footballleague.data.models.CompetitionDetails
import com.example.footballleague.ui.screens.competitions.components.DrawUrlImage
import com.example.footballleague.ui.screens.singleCompetiion.components.CompetitionDetailsTable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleMatchScreen(competitionDetails: CompetitionDetails?, onBackButtonPress: () -> Unit) {
    competitionDetails?.let {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(it.name ?: "", maxLines = 1, overflow = TextOverflow.Ellipsis) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                navigationIcon = {
                    IconButton(onClick = onBackButtonPress) {
                        Icon(
                            Icons.Rounded.ArrowBack,
                            "",
                            tint = MaterialTheme.colorScheme.background
                        )
                    }
                },
            )
        }) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                competitionDetails.emblem?.let {
                    DrawUrlImage(
                        url = competitionDetails.emblem,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                    )
                    Divider(Modifier.padding(vertical = 10.dp))
                }
                CompetitionDetailsTable(it, Modifier.padding(all = 8.dp))
            }
        }
    }
}
