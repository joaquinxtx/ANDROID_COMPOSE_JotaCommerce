package com.joaquindev.jotacommerce.presentation.screens.client.payments.form

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.IdentificationType
import com.joaquindev.jotacommerce.domain.model.Installment
import com.joaquindev.jotacommerce.domain.useCase.mercado_pago.MercadoPagoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientPaymentFormViewModel @Inject constructor(private val mercadoPagoUseCase: MercadoPagoUseCase) :
    ViewModel() {

    var identificationTypesResponse by mutableStateOf<Resource<List<IdentificationType>>?>(null)
        private set
    var installmentsResponse by mutableStateOf<Resource<Installment>?>(null)
        private set

    fun getIdentificationTypes() = viewModelScope.launch {
        identificationTypesResponse = Resource.Loading
        val result = mercadoPagoUseCase.getIdentificationType().first()
        identificationTypesResponse = result
        Log.d("ClientPaymentFormViewModel" , "DATA:${identificationTypesResponse}")
    }

    fun getInstallments(firstSixDigits:Int,amount:Double) = viewModelScope.launch {
        installmentsResponse = Resource.Loading
        val result = mercadoPagoUseCase.getInstallments(firstSixDigits, amount).first()
        installmentsResponse = result
        Log.d("ClientPaymentFormViewModel" , "DATA:${installmentsResponse}")
    }

}