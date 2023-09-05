package com.joaquindev.jotacommerce.presentation.screens.client.payments.installments.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.PayerCost
import com.joaquindev.jotacommerce.presentation.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentInstallmentsContent(installments:List<PayerCost>, navController: NavHostController , paddingValues: PaddingValues){

    var selectedInstallments by remember {
        mutableStateOf(installments[0])
    }

    var expanded by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.padding(20.dp).padding(paddingValues)) {
        TopBar(navController = navController , title = "Numero de cuotas" , arrowBack = true )
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
            expanded = !expanded
        }) {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = selectedInstallments.recommendedMessage,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Tipo de identificacion") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(containerColor = Color.White)
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                installments.forEachIndexed { index, installments ->
                    DropdownMenuItem(onClick = {
                        selectedInstallments = installments
                        expanded = false
                    }) {
                        Text(text = installments.recommendedMessage)
                    }
                }

            }

        }
    }

}