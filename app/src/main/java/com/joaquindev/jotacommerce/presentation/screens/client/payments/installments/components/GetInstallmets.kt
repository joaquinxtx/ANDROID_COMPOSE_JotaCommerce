package com.joaquindev.jotacommerce.presentation.screens.client.payments.installments.components


import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar

import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.ClientPaymentFormViewModel
import com.joaquindev.jotacommerce.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel

@Composable
fun GetInstallments(
navController: NavHostController,
    vm: ClientPaymentsInstallmentsViewModel= hiltViewModel(),
    paddingValues: PaddingValues
) {
    when (val response = vm.installmentsResponse) {
        Resource.Loading -> {

            ProgressBar()
        }

        is Resource.Success -> {
            ClientPaymentInstallmentsContent(
                paddingValues = paddingValues,
                installments =response.data.payerCosts,
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