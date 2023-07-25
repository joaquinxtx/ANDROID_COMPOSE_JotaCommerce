package com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components


import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
import com.joaquindev.jotacommerce.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.joaquindev.jotacommerce.presentation.screens.admin.product.list.AdminProductListViewModel

@Composable
fun DeleteProduct(

    vm: AdminProductListViewModel = hiltViewModel()
) {
    when (val response = vm.productsDeleteResponse) {
        Resource.Loading -> {

            ProgressBar()
        }

        is Resource.Success -> {
            Toast.makeText(LocalContext.current, "El Producto se elimino correctamante", Toast.LENGTH_SHORT)
                .show()

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