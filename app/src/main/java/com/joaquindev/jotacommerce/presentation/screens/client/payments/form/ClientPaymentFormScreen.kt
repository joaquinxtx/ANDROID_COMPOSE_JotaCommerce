package com.joaquindev.jotacommerce.presentation.screens.client.payments.form

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.components.ClientPaymentFormContent
import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.components.GetIdentificationTypes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentFormScreen(navController: NavHostController , vm : ClientPaymentFormViewModel = hiltViewModel()) {

    vm.getIdentificationTypes()

    Scaffold() {
        GetIdentificationTypes(paddingValues = it)
    }
}