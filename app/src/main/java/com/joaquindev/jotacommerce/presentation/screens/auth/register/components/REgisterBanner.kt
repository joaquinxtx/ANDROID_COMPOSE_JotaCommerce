package com.joaquindev.jotacommerce.presentation.screens.auth.register.components


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe2

@Composable
fun RegisterBanner(navController:NavHostController , modifier : Modifier){
    IconButton(onClick = { navController.popBackStack() } , modifier=modifier) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = Cafe2,
            modifier = modifier
                .size(34.dp)
        )
    }
    Icon(
        painter = painterResource(id = R.drawable.cofferegister),
        contentDescription = "",

        modifier = Modifier

            .height(85.dp)
            .width(85.dp),
        tint = Cafe2
    )
    Text(
        modifier = Modifier.padding(bottom = 15.dp),
        text = "Ingrese esta informacion",
        color = Cafe2,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}