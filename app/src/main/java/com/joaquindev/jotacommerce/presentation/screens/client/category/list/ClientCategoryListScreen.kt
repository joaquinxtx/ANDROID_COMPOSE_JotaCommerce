package com.joaquindev.jotacommerce.presentation.screens.client.category.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.components.TopBarClient
import com.joaquindev.jotacommerce.presentation.screens.client.category.list.components.GetCategories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientCategoryListScreen(navController: NavHostController , vm:ClientCategoryListViewModel = hiltViewModel()){
    Scaffold(topBar = { TopBarClient(
        navController = navController,
        photoUrl = vm.user?.image,
        profilePhoto = true,
    ) }) {
       GetCategories(navController = navController , paddingValues = it )
    }
}