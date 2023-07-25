package com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components.DeleteProduct
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components.GetProducts
import com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory.components.GetProductsByCategory
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_orange
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientProductByCategoryListScreen(navController: NavHostController, categoryParam: String) {
    val categoryParse = Category.fromJson(categoryParam).toJson()
    Scaffold() {
        GetProductsByCategory(navController = navController, paddingValues = it)

    }
}