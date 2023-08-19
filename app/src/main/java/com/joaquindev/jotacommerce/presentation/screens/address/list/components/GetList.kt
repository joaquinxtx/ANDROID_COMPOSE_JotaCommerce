package com.joaquindev.jotacommerce.presentation.screens.address.list.components


import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
import com.joaquindev.jotacommerce.presentation.screens.address.list.ClientAddressListViewModel
import com.joaquindev.jotacommerce.presentation.screens.admin.category.list.AdminCategoryListViewModel

@Composable
fun GetAddress(
    navController: NavHostController,
    vm: ClientAddressListViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    when (val response = vm.addressResponse) {
        Resource.Loading -> {

            ProgressBar()
        }

        is Resource.Success -> {
            ClientAddressListContent(
                paddingValues = paddingValues,
                addressList = response.data,
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