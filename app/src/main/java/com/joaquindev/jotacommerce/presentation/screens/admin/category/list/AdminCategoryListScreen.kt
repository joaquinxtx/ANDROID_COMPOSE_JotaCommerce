package com.joaquindev.jotacommerce.presentation.screens.admin.category.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.screens.admin.category.list.components.DeleteCategory
import com.joaquindev.jotacommerce.presentation.screens.admin.category.list.components.GetCategory
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_orange
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryListScreen(navController: NavHostController) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate(route = Graph.ADMIN_CATEGORY) },
            modifier = Modifier.padding(bottom = 80.dp),
            containerColor = Cafe_orange,
            contentColor = Cafe_white

        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
    }) {
        GetCategory(paddingValues = it, navController = navController)
    }
    DeleteCategory()

}