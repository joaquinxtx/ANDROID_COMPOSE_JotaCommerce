package com.joaquindev.jotacommerce.presentation.navigation.graph.profile

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.screen.profile.ProfileScreen
import com.joaquindev.jotacommerce.presentation.screens.profile.update.ProfileUpdateScreen


fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {

        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileUpdateScreen(navController, userParam = it)

            }
        }


    }
}