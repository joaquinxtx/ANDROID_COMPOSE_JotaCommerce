package com.joaquindev.jotacommerce.presentation.navigation.graph.admin

import androidx.compose.animation.*
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.Alignment
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
import com.joaquindev.jotacommerce.presentation.screens.admin.product.update.AdminProductUpdateScreen
import com.joaquindev.jotacommerce.presentation.screens.client.home.HomeClientScreen

import com.joaquindev.jotacommerce.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ) {

        composable(route = AdminCategoryScreen.CategoryCreate.route, enterTransition = {
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
            }) {
            AdminCategoryCreateScreen(navController)
        }
        composable(
            route = AdminCategoryScreen.CategoryUpdate.route
            , enterTransition = {
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
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {

                AdminCategoryUpdateScreen(navController, categoryParam = it)
            }
        }
        composable(
            route = AdminCategoryScreen.ProductList.route,

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

                AdminProductListScreen(navController, categoryParam = it)
            }
        }
        composable(
            route = AdminCategoryScreen.ProductCreate.route, enterTransition = {
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
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("category")?.let {

                AdminProductCreateScreen(navController, categoryParam = it)
            }
        }


    }
    composable(
        route = AdminCategoryScreen.ProductUpdate.route ,enterTransition = {
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

            AdminProductUpdateScreen(navController, productParam = it)
        }
    }


}
