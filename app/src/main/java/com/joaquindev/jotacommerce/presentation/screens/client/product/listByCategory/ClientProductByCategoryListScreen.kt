package com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.presentation.components.TopBarClient
import com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory.components.GetProductsByCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientProductByCategoryListScreen(navController: NavHostController, categoryParam: String) {
    val categoryParse = Category.fromJson(categoryParam).toJson()
    Scaffold(topBar = { TopBarClient(navController = navController, arrowBack = true) }) {
        GetProductsByCategory(navController = navController, paddingValues = it)

    }
}