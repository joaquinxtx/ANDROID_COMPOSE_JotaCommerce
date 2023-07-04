package com.joaquindev.jotacommerce.presentation.screens.admin.category.create

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.components.CreateCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryCreateScreen(navController: NavHostController) {
    Scaffold() {
        AdminCategoryCreateContent(paddingValues = it , navController)
    }
    CreateCategory()
}