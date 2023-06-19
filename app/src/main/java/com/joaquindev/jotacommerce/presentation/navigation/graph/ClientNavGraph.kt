package com.joaquindev.jotacommerce.presentation.navigation.graph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.screen.ClientScreen
import com.joaquindev.jotacommerce.presentation.screens.client.category.list.ClientCategoryListScreen
import com.joaquindev.jotacommerce.presentation.screens.client.product.ClientProductListScreen
import com.joaquindev.jotacommerce.presentation.screens.profile.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ) {
        composable(route = ClientScreen.ProductList.route) {

            ClientProductListScreen()

        }
        composable(route = ClientScreen.CategoryList.route) {
            ClientCategoryListScreen()

        }
        composable(route = ClientScreen.Profile.route) {
            ProfileScreen()
        }
    }
}