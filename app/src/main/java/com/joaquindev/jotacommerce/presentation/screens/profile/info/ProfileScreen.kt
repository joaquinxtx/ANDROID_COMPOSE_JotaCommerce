package com.joaquindev.jotacommerce.presentation.screens.profile.info

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.screens.profile.info.components.ProfileContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen( navController: NavHostController ){
    Scaffold(topBar = {TopBar(navController = navController ,  arrowBack = true , iconTint = Color.White)}) {
        ProfileContent( navController = navController)
    }
}