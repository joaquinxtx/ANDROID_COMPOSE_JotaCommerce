package com.joaquindev.jotacommerce.presentation.screens.client.home.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ClientScreen
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_beige

@Composable
fun ClientBottomBar(navController: NavHostController) {

    val screen = listOf(
        ClientScreen.ProductList,
        ClientScreen.CategoryList,
        ClientScreen.Profile,
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screen.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomAppBar(
            contentColor = contentColorFor(backgroundColor = Cafe_beige),
            
        ) {
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