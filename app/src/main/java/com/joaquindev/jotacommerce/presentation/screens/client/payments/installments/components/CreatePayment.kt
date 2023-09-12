package com.joaquindev.jotacommerce.presentation.screens.client.payments.installments.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.presentation.components.ProgressBar
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.joaquindev.jotacommerce.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel

@Composable
fun CreatePayment(navController: NavHostController, vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()) {
    val context = LocalContext.current
    when(val response = vm.paymentResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(key1 = Unit) {
                if (response.data.status == "approved") {
                    navController.navigate(route = ShoppingBagScreen.PaymentsStatus.passPaymentResponse(response.data.toJson())) {
                        popUpTo(ShoppingBagScreen.PaymentsInstallments.route) { inclusive = true}
                    }    
                }
                else {
                    Toast.makeText(context, "La transaccion fallo", Toast.LENGTH_SHORT).show()
                }
                
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}