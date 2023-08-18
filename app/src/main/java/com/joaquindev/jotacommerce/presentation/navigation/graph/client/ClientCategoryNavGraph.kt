package com.joaquindev.jotacommerce.presentation.navigation.graph.client

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ClientCategoryScreen
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ClientProductScreen
import com.joaquindev.jotacommerce.presentation.navigation.screen.roles.RolesScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.home.HomeAdminScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.AdminProductListScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.update.AdminProductUpdateScreen
import com.joaquindev.jotacommerce.presentation.screens.client.home.HomeClientScreen
import com.joaquindev.jotacommerce.presentation.screens.client.product.detail.ClientProductDetailScreen
import com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory.ClientProductByCategoryListScreen

import com.joaquindev.jotacommerce.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.ClientCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_CATEGORY,
        startDestination = ClientCategoryScreen.ProductList.route
    ) {

        composable(
            route = ClientCategoryScreen.ProductList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {

                ClientProductByCategoryListScreen(navController, categoryParam = it)
            }
        }

        composable(
            route = ClientCategoryScreen.ProductDetail.route,
            arguments = listOf(navArgument("product") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("product")?.let {

                ClientProductDetailScreen(navHostController = navController, productParam = it )
            }
        }


    }
}