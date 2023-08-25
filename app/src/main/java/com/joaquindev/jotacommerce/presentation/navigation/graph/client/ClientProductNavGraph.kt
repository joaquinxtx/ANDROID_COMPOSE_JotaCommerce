package com.joaquindev.jotacommerce.presentation.navigation.graph.client

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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

fun NavGraphBuilder.ClientProductNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_PRODUCT,
        startDestination = ClientProductScreen.ProductDetail.route
    ) {

        composable(
            route = ClientProductScreen.ProductDetail.route,

            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideOutOfContainer(
                    animationSpec = tween(300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            },
            arguments = listOf(navArgument("product") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("product")?.let {

                ClientProductDetailScreen(navController = navController, productParam = it )
            }
        }

    }
}
