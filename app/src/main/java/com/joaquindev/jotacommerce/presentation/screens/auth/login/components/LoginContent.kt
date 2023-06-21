package com.joaquindev.jotacommerce.presentation.screens.auth.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LoginContent(navController : NavHostController,paddingValues: PaddingValues ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        BackgroundImageLogin()

    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 70.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
       LoginBanner()
        Spacer(modifier = Modifier.weight(1f))
        LoginForm(navController = navController)

    }


}