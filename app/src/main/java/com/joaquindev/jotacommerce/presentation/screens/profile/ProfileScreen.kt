package com.joaquindev.jotacommerce.presentation.screens.profile

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.joaquindev.jotacommerce.presentation.screens.profile.components.ProfileContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(){
    Scaffold() {
        ProfileContent(paddingValues = it)
    }
}