package com.joaquindev.jotacommerce.presentation.screens.client.category.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.joaquindev.jotacommerce.presentation.screens.client.category.list.components.ClientCategoryListContent
import com.joaquindev.jotacommerce.presentation.screens.profile.components.ProfileContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientCategoryListScreen(){
    Scaffold() {
        ClientCategoryListContent(paddingValues = it)
    }
}