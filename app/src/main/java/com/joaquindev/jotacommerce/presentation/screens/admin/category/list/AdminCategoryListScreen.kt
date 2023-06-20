package com.joaquindev.jotacommerce.presentation.screens.admin.category.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.joaquindev.jotacommerce.presentation.screens.admin.category.list.components.AdminCategoryListContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryListScreen(){
    Scaffold() {
        AdminCategoryListContent(paddingValues = it)
    }
}