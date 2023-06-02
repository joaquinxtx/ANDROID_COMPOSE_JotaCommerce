package com.joaquindev.jotacommerce.presentation.screens.auth.register.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun RegisterContent(navController: NavHostController, paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        BackgroundImageRegister()
    }
    Column(
        Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RegisterBanner(navController = navController, modifier = Modifier.align(Alignment.Start) )
        Spacer(modifier = Modifier.weight(1f))
        RegisterForm()

    }
}