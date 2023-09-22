package com.joaquindev.jotacommerce.presentation.screens.admin.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.presentation.navigation.screen.admin.AdminScreen


@Composable
fun RowScope.AdminBottomBarItem(
    screen: AdminScreen,
    currentDestination: NavDestination,
    navController: NavHostController
) {
    val isSelected = currentDestination.hierarchy.any { it.route == screen.route }

    NavigationBarItem(
        selected = isSelected,
        onClick = {
            if (!isSelected) {
                navController.navigate(route = screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                }
            }
        },
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = stringResource(id = R.string.icon))
        }
    )
}