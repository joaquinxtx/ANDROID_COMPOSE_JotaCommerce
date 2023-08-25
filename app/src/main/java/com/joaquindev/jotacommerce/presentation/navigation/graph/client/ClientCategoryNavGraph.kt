package com.joaquindev.jotacommerce.presentation.navigation.graph.client

import androidx.compose.animation.*
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.Alignment
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.joaquindev.jotacommerce.presentation.navigation.Graph

import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ClientCategoryScreen

import com.joaquindev.jotacommerce.presentation.screens.client.product.detail.ClientProductDetailScreen
import com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory.ClientProductByCategoryListScreen




fun NavGraphBuilder.ClientCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CLIENT_CATEGORY,
        startDestination = ClientCategoryScreen.ProductList.route
    ) {

        composable(
            route = ClientCategoryScreen.ProductList.route,
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
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {

                ClientProductByCategoryListScreen(navController, categoryParam = it)
            }
        }

        composable(
            route = ClientCategoryScreen.ProductDetail.route, enterTransition = {
                scaleIn(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) +  expandIn(expandFrom = Alignment.TopStart)
            },
            exitTransition = {
                scaleOut(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + shrinkOut(shrinkTowards = Alignment.TopStart)
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
