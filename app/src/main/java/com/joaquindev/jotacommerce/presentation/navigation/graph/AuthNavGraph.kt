package com.joaquindev.jotacommerce.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.joaquindev.jotacommerce.presentation.navigation.Graph
import com.joaquindev.jotacommerce.presentation.navigation.screen.AuthScreen
import com.joaquindev.jotacommerce.presentation.screens.auth.LoginScreen
import com.joaquindev.jotacommerce.presentation.screens.auth.register.RegisterScreen
import com.joaquindev.jotacommerce.presentation.screens.home.HomeScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route =  Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AuthScreen.Register.route){
            RegisterScreen(navController)
        }
        composable(route = AuthScreen.Home.route){
           HomeScreen(navController)
        }
    }
}