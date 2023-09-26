package com.joaquindev.jotacommerce.presentation.screens.auth.login

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.auth.login.components.Login
import com.joaquindev.jotacommerce.presentation.screens.auth.login.components.LoginContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController){
    Scaffold{ paddingValues ->
        LoginContent(navController = navController,  paddingValues)
    }
    Login(navController = navController)
}

