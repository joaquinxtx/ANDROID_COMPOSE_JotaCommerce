package com.joaquindev.jotacommerce.presentation.navigation.graph

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.joaquindev.jotacommerce.presentation.navigation.Graph

@Composable
fun RootNavGraph(navController:NavHostController){
    NavHost(
        navController = navController,
        route= Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navController)
    }
}