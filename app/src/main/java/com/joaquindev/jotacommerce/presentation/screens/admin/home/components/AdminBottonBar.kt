package com.joaquindev.jotacommerce.presentation.screens.admin.home.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminScreen


@Composable
fun AdminBottomBar(navController: NavHostController) {

    val screen = listOf(
        AdminScreen.CategoryList,
        AdminScreen.Profile,
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screen.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomAppBar(


        ) {
            screen.forEach { screen ->
                if (currentDestination != null) {
                    AdminBottomBarItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }
    }

}