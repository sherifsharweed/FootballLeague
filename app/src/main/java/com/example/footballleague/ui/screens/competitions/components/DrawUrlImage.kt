package com.example.footballleague.ui.screens.competitions.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.footballleague.R

@Composable
fun DrawUrlImage(url: String?, modifier: Modifier) {
    url?.let {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(it)
                .crossfade(true)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = stringResource(R.string.emblem),
            contentScale = ContentScale.Fit,
            modifier = modifier
        )
    }
}