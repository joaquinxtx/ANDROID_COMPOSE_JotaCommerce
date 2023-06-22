package com.joaquindev.jotacommerce.presentation.screens.profile.info

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joaquindev.jotacommerce.presentation.screens.profile.info.components.ProfileContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen( navController: NavHostController ){
    Scaffold() {
        ProfileContent(paddingValues = it, navController = navController)
    }
}