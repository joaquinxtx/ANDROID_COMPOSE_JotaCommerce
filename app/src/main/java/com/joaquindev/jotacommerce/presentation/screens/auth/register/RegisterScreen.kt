package com.joaquindev.jotacommerce.presentation.screens.auth.register



import androidx.compose.material3.*

import androidx.compose.runtime.Composable


import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.auth.register.components.RegisterContent
import com.joaquindev.jotacommerce.presentation.screens.auth.register.components.RegisterResponse


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController:NavHostController){
    Scaffold {

        RegisterContent(navController = navController, paddingValues = it )
    }
    RegisterResponse(navController = navController)
}
