package com.joaquindev.jotacommerce.presentation.screens.admin.category.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.Category


@Composable
fun AdminCategoryListContent(navController: NavHostController,categories:List<Category> , paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues).fillMaxSize()
    ) {
        items(
            items= categories
        ){
            AdminCategoryListItem(category = it, navController = navController)
        }
    }
}