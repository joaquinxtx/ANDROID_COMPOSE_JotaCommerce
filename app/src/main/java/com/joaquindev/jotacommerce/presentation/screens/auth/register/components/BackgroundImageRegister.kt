package com.joaquindev.jotacommerce.presentation.screens.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.joaquindev.jotacommerce.R

@Composable
fun BackgroundImageRegister(){
    Image(
        painter = painterResource(id = R.drawable.perfiluser),
        contentDescription = stringResource(id = R.string.banner),
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
            setToScale(
                0.6f,
                0.6f,
                0.6f,
                1f
            )

        }))
}