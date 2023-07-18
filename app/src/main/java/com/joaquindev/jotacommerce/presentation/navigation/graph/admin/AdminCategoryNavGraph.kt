package com.joaquindev.jotacommerce.presentation.navigation.graph.admin

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminCategoryScreen
import com.joaquindev.jotacommerce.presentation.navigation.screen.roles.RolesScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.home.HomeAdminScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.AdminProductListScreen
import com.joaquindev.jotacommerce.presentation.screens.client.home.HomeClientScreen

import com.joaquindev.jotacommerce.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ) {

        composable(route = AdminCategoryScreen.CategoryCreate.route) {
            AdminCategoryCreateScreen(navController)
        }
        composable(
            route = AdminCategoryScreen.CategoryUpdate.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {

                AdminCategoryUpdateScreen(navController, categoryParam = it )
            }
        }
composable(
            route = AdminCategoryScreen.ProductList.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {

                AdminProductListScreen(navController, categoryParam = it )
            }
        }


    }
    composable(
            route = AdminCategoryScreen.ProductCreate.route,
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {

                AdminProductCreateScreen(navController, categoryParam = it )
            }
        }


    }
