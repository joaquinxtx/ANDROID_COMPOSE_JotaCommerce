package com.joaquindev.jotacommerce.presentation.navigation.graph.root

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.graph.auth.AuthNavGraph
import com.joaquindev.jotacommerce.presentation.navigation.graph.roles.RolesNavGraph


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        AuthNavGraph(navController)
        RolesNavGraph(navController)

    }
}