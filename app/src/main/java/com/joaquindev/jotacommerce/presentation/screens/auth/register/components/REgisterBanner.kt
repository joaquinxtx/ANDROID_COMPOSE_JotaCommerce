package com.joaquindev.jotacommerce.presentation.screens.auth.register.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@Composable
fun RegisterBanner(navController:NavHostController , modifier : Modifier){
    IconButton(onClick = { navController.popBackStack() } , modifier=modifier) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.icon_arrow_back),
            tint = Cafe_white,
            modifier = modifier
                .size(34.dp)
        )
    }
    Image(
        painter = painterResource(id = R.drawable.latte),
        contentDescription = stringResource(id = R.string.image),
        modifier = Modifier.size(150.dp)
    )
    Text(
        modifier = Modifier.padding(bottom = 15.dp),
        text = stringResource(id = R.string.enter_this_information),
        color = Cafe_white,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}