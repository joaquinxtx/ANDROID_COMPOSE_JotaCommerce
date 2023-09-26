package com.joaquindev.jotacommerce.presentation.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminMenu  (
    val route: String,
    val title:String,
    val icon: ImageVector
) {
    object CategoryList: AdminMenu(
        route = "admin/category/list",
        title = "categorias",
        icon = Icons.Default.List
    )
        object ProductList: AdminMenu(
       route = "admin/product/list",
      title = "productos",
       icon = Icons.Default.ThumbUp
   )
    object Profile: AdminMenu(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
    object CreateCategory: AdminMenu(
        route = "admin/category/create",
        title = "Crear Categoria",
        icon = Icons.Default.Add
    )


}
