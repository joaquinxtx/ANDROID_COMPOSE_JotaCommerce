package com.joaquindev.jotacommerce.presentation.screens.admin.product.create.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.joaquindev.jotacommerce.R
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
import com.joaquindev.jotacommerce.presentation.screens.admin.product.create.AdminProductCreateViewModel

@Composable
fun CreateProduct(vm: AdminProductCreateViewModel = hiltViewModel()) {
    when (val response = vm.productResponse) {
        Resource.Loading -> {

            ProgressBar()
        }

        is Resource.Success -> {
            Toast.makeText(LocalContext.current, stringResource(id = R.string.i_believe_the_product_correctly), Toast.LENGTH_LONG)
                .show()
            vm.clearForm()

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