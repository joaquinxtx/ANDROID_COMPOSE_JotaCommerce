package com.joaquindev.jotacommerce.presentation.navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen (val route: String,
                         val title:String,
                         val icon: ImageVector
) {
    object CategoryList: ClientScreen(
        route = "client/category/list",
        title = "categorias",
        icon = Icons.Default.List
    )
    object ProductList: ClientScreen(
        route = "client/product/list",
        title = "productos",
        icon = Icons.Default.ThumbUp
    )
    object Profile: ClientScreen(
        route = "client/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}