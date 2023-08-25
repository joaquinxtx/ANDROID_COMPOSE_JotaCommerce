package com.joaquindev.jotacommerce.presentation.navigation.graph.client

import androidx.compose.animation.*
import androidx.compose.animation.core.*
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
        startDestination = ClientScreen.ProductList.route,


        ) {
        composable(route = ClientScreen.ProductList.route
           , enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            }
            )
    {

            ClientProductListScreen(navController)

        }
      composable(route = ClientScreen.CategoryList.route
            ,enterTransition = {
              fadeIn(
                  animationSpec = tween(
                      300, easing = LinearEasing
                  )
              ) + slideIntoContainer(
                  animationSpec = tween(300, easing = EaseIn),
                  towards = AnimatedContentTransitionScope.SlideDirection.Start
              )
          }
        ) {
            ClientCategoryListScreen(navController)

        }
        composable(route = ClientScreen.Profile.route,
                enterTransition = {
            fadeIn(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(300, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        }
        ) {
            ProfileScreen(navController)
        }

        ProfileNavGraph(navController)
        ClientCategoryNavGraph(navController)
        ClientProductNavGraph(navController)
        ShoppingBagNavGraph(navController)
    }
}