package com.joaquindev.jotacommerce.presentation.screens.profile.update


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.screens.profile.update.components.ProfileUpdateContent
import com.joaquindev.jotacommerce.presentation.screens.profile.update.components.UpdateUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileUpdateScreen(navController: NavHostController , userParam:String){

    Scaffold(
topBar = { TopBar(navController = navController ,  arrowBack = true , iconTint = Color.White) }
    ) {
        ProfileUpdateContent(paddingValues = it)
    }
    UpdateUser()
}