package com.joaquindev.jotacommerce.presentation.screens.client.payments.form.components


import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar

import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.ClientPaymentFormViewModel

@Composable
fun GetIdentificationTypes(

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
                identificationType = response.data.map{identificationType -> identificationType.id  }
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