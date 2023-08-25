package com.joaquindev.jotacommerce.presentation.screens.client.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ClientScreen
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_beige
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_orange

@Composable
fun RowScope.ClientBottomBarItem(
    screen: ClientScreen,
    currentDestination: NavDestination,
    navController: NavHostController
) {
    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    NavigationBarItem(
        selected = isSelected,
        onClick = {
            if (!isSelected) {
                navController.navigate(route = screen.route) {
                    // Limpia la pila de navegación hasta el inicio cuando navegas a una nueva pantalla
                    popUpTo(navController.graph.findStartDestination().id)
                }
            }
        },
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "")
        }
    )
}