package com.joaquindev.jotacommerce.presentation.screens.admin.category.update

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.components.CreateCategory
import com.joaquindev.jotacommerce.presentation.screens.admin.category.update.components.AdminCategoryUpdateContent
import com.joaquindev.jotacommerce.presentation.screens.admin.category.update.components.UpdateCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController, categoryParam:String) {
    Scaffold() {
        AdminCategoryUpdateContent(paddingValues = it , navController)
    }
    UpdateCategory()
}