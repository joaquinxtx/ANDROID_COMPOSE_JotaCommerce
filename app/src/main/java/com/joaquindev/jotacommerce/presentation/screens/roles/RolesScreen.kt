package com.joaquindev.jotacommerce.presentation.screens.roles

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.roles.components.RolesContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RolesScreen(navController: NavHostController){
    Scaffold(
        topBar = { MediumTopAppBar(title = { Text(text = "Selecciona un rol")} )}
    ) {
        RolesContent(it , navController = navController)

    }
}