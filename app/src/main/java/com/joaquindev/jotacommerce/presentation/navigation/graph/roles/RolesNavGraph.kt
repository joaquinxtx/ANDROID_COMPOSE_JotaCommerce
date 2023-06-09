package com.joaquindev.jotacommerce.presentation.navigation.graph.roles

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.screen.roles.RolesScreen
import com.joaquindev.jotacommerce.presentation.screens.admin.home.HomeAdminScreen
import com.joaquindev.jotacommerce.presentation.screens.client.home.HomeClientScreen

import com.joaquindev.jotacommerce.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){
    navigation(
        route =  Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ){

        composable(route = RolesScreen.Roles.route){
            RolesScreen(navController)
        }
        composable(route = Graph.CLIENT) {
            HomeClientScreen()
        }
        composable(route = Graph.ADMIN) {
            HomeAdminScreen()
        }

    }
}