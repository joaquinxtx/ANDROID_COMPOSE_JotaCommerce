package com.joaquindev.jotacommerce.presentation.navigation.graph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.screen.AdminScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.AdminProductListScreen
import com.joaquindev.jotacommerce.presentation.screens.profile.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ) {
        composable(route = AdminScreen.ProductList.route) {

            AdminProductListScreen()

        }
        composable(route = AdminScreen.CategoryList.route) {
            AdminCategoryListScreen()

        }
        composable(route = AdminScreen.Profile.route) {
            ProfileScreen()
        }
    }
}