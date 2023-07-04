package com.joaquindev.jotacommerce.presentation.screens.admin.category.create.components


import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
import com.joaquindev.jotacommerce.presentation.screens.admin.category.create.AdminCategoryCreateViewModel
import com.joaquindev.jotacommerce.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun CreateCategory(vm: AdminCategoryCreateViewModel = hiltViewModel()) {
    when (val response = vm.categoryResponse) {
        Resource.Loading -> {

            ProgressBar()
        }

        is Resource.Success -> {

            Toast.makeText(LocalContext.current, "Los datos fueron actualizados", Toast.LENGTH_LONG)
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