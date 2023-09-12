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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.PayerCost
import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentsInstallmentsContent(
    paddingValues: PaddingValues,
    installments: List<PayerCost>,
    vm: ClientPaymentsInstallmentsViewModel = hiltViewModel(),
    navController: NavHostController
) {


    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {


            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = vm.selectedInstallment?.recommendedMessage ?: "",
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Tipo de identificacion") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },

                colors = ExposedDropdownMenuDefaults.textFieldColors(containerColor = Color.White)
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                installments.forEachIndexed { index, installment ->
                    DropdownMenuItem(onClick = {
                        vm.selectedInstallment = installment
                        expanded = false
                    }) {
                        Text(text = installment.recommendedMessage)
                    }
                }

            }

        }
    }

}