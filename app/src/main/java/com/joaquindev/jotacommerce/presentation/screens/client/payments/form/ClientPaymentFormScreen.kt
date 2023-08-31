package com.joaquindev.jotacommerce.presentation.screens.client.payments.form

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.components.ClientPaymentFormContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentFormScreen(navController: NavHostController , vm : ClientPaymentFormViewModel) {

    vm.getIdentificationTypes()
    vm.getInstallments(525413,10000.0)
    Scaffold() {
        ClientPaymentFormContent(paddingValues = it)
    }
}