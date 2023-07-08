package com.joaquindev.jotacommerce.presentation.screens.client.category.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
import com.joaquindev.jotacommerce.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.joaquindev.jotacommerce.presentation.screens.client.category.list.ClientCategoryListViewModel

@Composable
fun GetCategories(
    navController: NavHostController,
    vm: ClientCategoryListViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    when (val response = vm.categoriesResponse) {
        Resource.Loading -> {

            ProgressBar()
        }

        is Resource.Success -> {
            ClientCategoryListContent(
                categories = response.data,
                paddingValues = paddingValues,
                navController = navController
            )

        }
        is Resource.Failure -> {

            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT)
                .show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error Desconocido", Toast.LENGTH_SHORT).show()

            }
        }
    }
}