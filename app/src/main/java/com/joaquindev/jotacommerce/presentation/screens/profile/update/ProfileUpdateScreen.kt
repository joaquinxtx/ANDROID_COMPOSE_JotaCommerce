package com.joaquindev.jotacommerce.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.profile.update.components.ProfileUpdateContent
import com.joaquindev.jotacommerce.presentation.screens.profile.update.components.UpdateUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileUpdateScreen(navController: NavHostController , userParam:String){

    Scaffold(

    ) {
        ProfileUpdateContent(paddingValues = it, navController = navController)
    }
    UpdateUser()
}