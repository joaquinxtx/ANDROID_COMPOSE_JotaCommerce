package com.joaquindev.jotacommerce.presentation.screens.client.payments.form.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentFormContent(paddingValues: PaddingValues) {

    Text(modifier = Modifier.padding(paddingValues), text = "ClientPaymentFormContent")
}