package com.joaquindev.jotacommerce.presentation.navigation.screen.admin

import com.joaquindev.jotacommerce.presentation.navigation.screen.auth.AuthScreen


class AdminCategoryScreen (val route: String) {
    object CategoryCreate: AuthScreen("admin/category/create")
}