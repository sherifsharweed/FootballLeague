package com.example.footballleague.ui.screens.singleCompetiion.components

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.footballleague.data.models.CompetitionDetails
import java.text.SimpleDateFormat

@Composable
fun TableCell(
    title: String,
    value: String?,
) {
    Column(
        modifier = Modifier.border(1.dp, Color.Black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            Text(
                text = title,
                Modifier
                    .weight(0.3f)
                    .padding(8.dp)
            )
            Text(
                text = value ?: "-",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis, modifier =
                Modifier
                    .weight(0.7f)
                    .fillMaxHeight()
                    .drawBehind {
                        val strokeWidth = 1 * density
                        //Draw line function for left border
                        drawLine(
                            Color.Black,
                            Offset(0f, strokeWidth),
                            Offset(0f, size.height),
                            strokeWidth
                        )
                    }
                    .padding(8.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )

        }
        Divider()

    }
}

@Composable
fun CompetitionDetailsTable(competitionDetails: CompetitionDetails, modifier: Modifier) {
    Column(modifier = modifier) {
        Divider()
        TableCell(title = "Location", value = competitionDetails.areaName)
        TableCell(title = "Matches For Day", value = competitionDetails.currentMatchDay?.toString())
        TableCell(
            title = "Sessions",
            value = competitionDetails.numberOfAvailableSeasons?.toString()
        )
        TableCell(title = "Start At", value = competitionDetails.startDate)
        TableCell(title = "End At", value = competitionDetails.endDate)
        TableCell(title = "Last Update", value = formatDate(competitionDetails.lastUpdated))
    }
}

@SuppressLint("SimpleDateFormat")
fun formatDate(createDate: String?): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date = parser.parse(createDate ?: "")
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    return date?.let { formatter.format(it) }
}
