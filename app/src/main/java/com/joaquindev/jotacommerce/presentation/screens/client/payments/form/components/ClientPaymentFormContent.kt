package com.joaquindev.jotacommerce.presentation.screens.client.payments.form.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape


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

import com.joaquindev.jotacommerce.presentation.components.DefaultButton
import com.joaquindev.jotacommerce.presentation.components.DefaultTextField
import com.joaquindev.jotacommerce.presentation.components.TopBar
import com.joaquindev.jotacommerce.presentation.navigation.screen.client.ShoppingBagScreen
import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.ClientPaymentFormViewModel
import com.joaquindev.jotacommerce.presentation.screens.client.payments.form.mapper.toCardTokenBody
import com.joaquindev.jotacommerce.presentation.ui.theme.CafeTransparent
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_blue
import com.joaquindev.jotacommerce.presentation.ui.theme.Cafe_white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentFormContent(
    paddingValues: PaddingValues,
    identificationTypes: List<String>,
    vm: ClientPaymentFormViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val state = vm.state
    var selectedItem by remember { mutableStateOf(identificationTypes[0]) }
    vm.onIdentificationTypeInput(selectedItem)
    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(paddingValues)

    ) {
        TopBar(
            navController = navController,
            title = "Formulario de pago",
            arrowBack = true,
            titleColor = Cafe_white,
            iconTint = Cafe_white
        )
        Card(
            modifier = Modifier

                .fillMaxSize()
                .background(Cafe_blue)
                .padding(top = 10.dp),
            shape = RoundedCornerShape(
                topEnd = 30.dp,
                topStart = 30.dp
            )
        ) {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {

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
                Spacer(modifier = Modifier.height(10.dp))
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = selectedItem,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text(text = "Tipo de identificacion") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },


                        colors = ExposedDropdownMenuDefaults.textFieldColors(containerColor = CafeTransparent)


                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    ExposedDropdownMenu(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        identificationTypes.forEachIndexed { index, identification ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedItem = identification
                                    vm.onIdentificationTypeInput(selectedItem)
                                    expanded = false
                                },
                                text = { Text(text = identification) }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.number,
                    onValueChange = { vm.onIdentificationNumberInput(it) },
                    label = "Numero de identification",
                    icon = Icons.Default.List,
                    keyboardType = KeyboardType.Number

                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Continuar",
                    onClick = {
                        navController.navigate(
                            route = ShoppingBagScreen.PaymentsInstallments.passPaymentForm(
                                state.toCardTokenBody().toJson()
                            )
                        ) {
                            popUpTo(ShoppingBagScreen.PaymentsForm.route) { inclusive = true }
                        }
                    }
                )


            }
            }


    }
}