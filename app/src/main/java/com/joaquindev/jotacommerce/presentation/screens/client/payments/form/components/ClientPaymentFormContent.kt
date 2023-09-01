package com.joaquindev.jotacommerce.presentation.screens.client.payments.form.components

import androidx.compose.foundation.layout.*


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.joaquindev.jotacommerce.domain.model.IdentificationType
import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.ClientPaymentFormViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentFormContent(
    paddingValues: PaddingValues,
    identificationType: List<String>,
    vm: ClientPaymentFormViewModel = hiltViewModel()
) {
    var selectedItem by remember {
        mutableStateOf(identificationType[0])
    }
    val state = vm.state
    var expanded by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)
    ) {

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.cardNumber,
            onValueChange = { vm.onCardNumberInput(it) },
            label = "Numero de la tarjeta",
            icon = Icons.Default.Settings
        )

            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.expirationYear,
                onValueChange = { vm.onYearExpirationInput(it) },
                label = "Año de expiracion YYYY",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number
            )
            DefaultTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.expirationMonth,
                onValueChange = { vm.onMonthInput(it) },
                label = "Mes de expiracion MM",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number
            )


        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.name,
            onValueChange = { vm.onNameInput(it) },
            label = "Nombre del titular",
            icon = Icons.Default.Person,

            )
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.securityCode,
            onValueChange = { vm.onSecurityCodeInput(it) },
            label = "Codigo de seguridad",
            icon = Icons.Default.Lock,

            )

        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
            expanded = !expanded
        }) {

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Tipo de identificacion") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(containerColor = Color.White)
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                identificationType.forEachIndexed { index, identification ->
                    androidx.compose.material.DropdownMenuItem(onClick = {
                        selectedItem = identification
                        expanded = false
                    }) {
                        Text(text = identification)
                    }
                }

            }

        }
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.number,
            onValueChange = { vm.onIdentificationNumberInput(it) },
            label = "Numero de identification",
            icon = Icons.Default.List,
            keyboardType = KeyboardType.Number

        )
        Spacer(modifier = Modifier.weight(1f))
        DefaultButton(modifier = Modifier.fillMaxWidth(), text = "Continuar", onClick = {})

    }
}