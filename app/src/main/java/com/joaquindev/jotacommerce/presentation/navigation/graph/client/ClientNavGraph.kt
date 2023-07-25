package com.joaquindev.jotacommerce.presentation.navigation.graph.client

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.graph.profile.ProfileNavGraph
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ClientScreen
import com.joaquindev.jotacommerce.presentation.screens.client.category.list.ClientCategoryListScreen

import com.joaquindev.jotacommerce.presentation.screens.client.product.list.ClientProductListScreen
import com.joaquindev.jotacommerce.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ) {
        composable(route = ClientScreen.ProductList.route) {

            ClientProductListScreen(navController)

        }
        composable(route = ClientScreen.CategoryList.route) {
            ClientCategoryListScreen(navController)

        }
        composable(route = ClientScreen.Profile.route) {
            ProfileScreen(navController)
        }

        ProfileNavGraph(navController)
        ClientCategoryNavGraph(navController)
    }
}