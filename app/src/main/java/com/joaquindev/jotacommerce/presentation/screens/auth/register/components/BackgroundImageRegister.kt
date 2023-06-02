package com.joaquindev.jotacommerce.presentation.screens.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.joaquindev.jotacommerce.R

@Composable
fun BackgroundImageRegister(){
    Image(
        painter = painterResource(id = R.drawable.coffe4),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
            setToScale(
                0.5f,
                0.5f,
                0.5f,
                1f
            )

        }))
}