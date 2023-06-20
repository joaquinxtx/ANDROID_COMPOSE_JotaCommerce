package com.joaquindev.jotacommerce.presentation.screens.client.home.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.joaquindev.jotacommerce.presentation.navigation.screen.ClientScreen

@Composable
fun ClientBottomBar(navController: NavHostController) {

    val screen = listOf(
        ClientScreen.ProductList,
        ClientScreen.Profile,
        ClientScreen.CategoryList,
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screen.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomAppBar() {
            screen.forEach {
                if (currentDestination != null) {
                    ClientBottomBarItem(
                        screen = it,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }
    }

}