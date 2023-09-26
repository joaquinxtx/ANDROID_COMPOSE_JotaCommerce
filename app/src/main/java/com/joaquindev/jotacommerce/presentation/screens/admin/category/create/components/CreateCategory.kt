package com.joaquindev.jotacommerce.presentation.screens.admin.category.create.components


import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.joaquindev.jotacommerce.R

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.AdminCategoryCreateViewModel


@Composable
fun CreateCategory(vm: AdminCategoryCreateViewModel = hiltViewModel()) {
    when (val response = vm.categoryResponse) {
        Resource.Loading -> {

            ProgressBar()
        }

        is Resource.Success -> {
            vm.clearForm()
            Toast.makeText(LocalContext.current, stringResource(id = R.string.the_data_was_updated), Toast.LENGTH_LONG)
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