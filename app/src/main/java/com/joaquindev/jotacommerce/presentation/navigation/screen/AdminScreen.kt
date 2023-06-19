package com.joaquindev.jotacommerce.presentation.navigation.screen

import androidx.compose.ui.graphics.vector.ImageVector

class AdminScreen (
    val route: String,
    val title:String,
    val icon:ImageVector
    ) {
    object Roles : AuthScreen("roles")
}