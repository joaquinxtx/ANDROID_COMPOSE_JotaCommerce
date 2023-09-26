package com.joaquindev.jotacommerce.presentation.screens.admin.product.list.components


import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
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
            Toast.makeText(LocalContext.current, stringResource(id = R.string.the_product_was_disposed_of_correctly), Toast.LENGTH_SHORT)
                .show()

        }
        is Resource.Failure -> {

            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT)
                .show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, stringResource(id = R.string.unknown_error), Toast.LENGTH_SHORT).show()

            }
        }
    }
}