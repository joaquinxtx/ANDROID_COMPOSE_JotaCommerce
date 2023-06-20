package com.joaquindev.jotacommerce.presentation.screens.admin.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.navigation.screen.AdminScreen


@Composable
fun RowScope.AdminBottomBarItem(
    screen: AdminScreen,
    currentDestination: NavDestination,
    navController: NavHostController
) {
    NavigationBarItem(selected = currentDestination.hierarchy.any {
        it.route == screen.route
    }, onClick = {
        navController.navigate(route = screen.route) {
            popUpTo(navController.graph.findStartDestination().id)
        }
    }, label = {
        Text(text = screen.title)
    }, icon = {
            Icon(imageVector = screen.icon, contentDescription = "")
        })
}