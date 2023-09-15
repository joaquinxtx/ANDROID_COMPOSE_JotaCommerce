package com.joaquindev.jotacommerce.presentation.screens.client.payments.status

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.joaquindev.jotacommerce.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.presentation.MainActivity
import com.joaquindev.jotacommerce.presentation.components.DefaultButton


@Composable
fun ClientPaymentsStatusContent(paddingValues: PaddingValues, navController: NavHostController, vm: ClientPaymentsStatusViewModel = hiltViewModel()) {

    val activity = LocalContext.current as? Activity

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id =R.drawable.latte) ,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Tu orden fue procesada exitosamente /nUtilizando la tarjeta ${vm.paymentResponse.paymentMethodID} **** ${vm.paymentResponse.card.lastFourDigits}",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "Mira el estado de tu compra en la seccion de pedidos",
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Finalizar compra",
            onClick = {
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            }
        )
    }
    
}
