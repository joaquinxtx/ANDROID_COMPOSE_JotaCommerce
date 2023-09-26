package com.joaquindev.jotacommerce.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientMenu  (
    val route: String,
    val title:String,
    val icon: ImageVector
) {
    object Products: ClientMenu(
        route = "client/product/list",
        title = "Productos",
        icon = Icons.Default.List
    )
        object ShoppingCart: ClientMenu(
       route = "client/shopping_bag",
      title = "Cart",
       icon = Icons.Default.ThumbUp
   )
    object Profile: ClientMenu(
        route = "client/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
    object Categories: ClientMenu(
        route = "client/category/list",
        title = "Categorias",
        icon = Icons.Default.Add
    )


}
