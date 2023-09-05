package com.joaquindev.jotacommerce.presentation.screens.client.payments.installments

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.screens.client.payments.installments.components.GetInstallments

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentsInstallmentsScreen(navController: NavHostController , paymentFormParam:String , vm:ClientPaymentsInstallmentsViewModel = hiltViewModel()) {
Log.d("ClientPaymentsInstallmentsScreen", "Param:${vm.cardTokenBody} ")

    vm.getInstallments(vm.cardTokenBody.cardNumber.substring(0,6).toInt(),10000.0)
    Scaffold() {
        GetInstallments(navController = navController, paddingValues = it )
    }
}