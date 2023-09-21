package com.joaquindev.jotacommerce.presentation.screens.admin.category.update

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.screens.admin.category.update.components.AdminCategoryUpdateContent
import com.joaquindev.jotacommerce.presentation.screens.admin.category.update.components.UpdateCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController, categoryParam:String) {
    Scaffold(topBar = { TopBar(navController = navController , arrowBack = true , iconTint = Color.White ) }) {
        AdminCategoryUpdateContent(paddingValues = it )
    }
    UpdateCategory()
}