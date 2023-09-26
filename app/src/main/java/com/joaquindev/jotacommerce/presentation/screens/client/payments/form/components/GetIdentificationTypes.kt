package com.joaquindev.jotacommerce.presentation.screens.client.payments.form.components


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

import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.ClientPaymentFormViewModel

@Composable
fun GetIdentificationTypes(
navController: NavHostController,
    vm: ClientPaymentFormViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    when (val response = vm.identificationTypesResponse) {
        Resource.Loading -> {

            ProgressBar()
        }

        is Resource.Success -> {
            ClientPaymentFormContent(
                paddingValues = paddingValues,
                navController = navController,
                identificationTypes = response.data.map { identificationType -> identificationType.id }
            )

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