package com.joaquindev.jotacommerce.presentation.navigation.screen.admin

import com.joaquindev.jotacommerce.presentation.navigation.screen.auth.AuthScreen


open class AdminCategoryScreen (val route: String) {
    object CategoryCreate: AdminCategoryScreen("admin/category/create")
    object CategoryUpdate: AdminCategoryScreen("admin/category/update/{category}"){
        fun passCategory(category:String)="admin/category/update/${category}"
    }

}