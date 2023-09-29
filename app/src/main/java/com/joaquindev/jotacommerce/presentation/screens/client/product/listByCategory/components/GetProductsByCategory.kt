package com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory.components


import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
import com.joaquindev.jotacommerce.presentation.screens.client.product.listByCategory.ClientProductByCategoryListViewModel

@Composable
fun GetProductsByCategory(
    navController: NavHostController,
    vm: ClientProductByCategoryListViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    when (val response = vm.productsResponse) {
        Resource.Loading -> {

            ProgressBar()
        }

        is Resource.Success -> {
            ClientProductByCategoryListContent(
                products = response.data,
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
                Toast.makeText(LocalContext.current, stringResource(id = R.string.unknown_error) , Toast.LENGTH_SHORT).show()

            }
        }
    }
}