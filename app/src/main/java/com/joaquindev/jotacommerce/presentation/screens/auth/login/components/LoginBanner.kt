package com.joaquindev.jotacommerce.presentation.screens.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joaquindev.jotacommerce.R

@Composable
fun LoginBanner(){
    Image(
        painter = painterResource(id = R.drawable.latte),
        contentDescription = stringResource(id = R.string.image),
        modifier = Modifier.size(150.dp)
    )
    Text(
        text = stringResource(id = R.string.title_coffee),
        color = Color(color = 0xFFEEDACD),
        fontSize = 29.sp,
        fontWeight = FontWeight.Bold
    )
}