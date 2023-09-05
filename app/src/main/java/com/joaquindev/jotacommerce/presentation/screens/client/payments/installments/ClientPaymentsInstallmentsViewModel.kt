package com.joaquindev.jotacommerce.presentation.screens.client.payments.installments

import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.CardTokenBody
import com.joaquindev.jotacommerce.domain.model.Installment
import com.joaquindev.jotacommerce.domain.useCase.mercado_pago.MercadoPagoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ClientPaymentsInstallmentsViewModel @Inject constructor(
    private val mercadoPagoUseCase: MercadoPagoUseCase,
    private val savedStateHandle: SavedStateHandle
    ) :
    ViewModel() {

    var data =savedStateHandle.get<String>("payment_form")
    val cardTokenBody = CardTokenBody.fromJson(data!!)

    var installmentsResponse by mutableStateOf<Resource<Installment>?>(null)
        private set

    fun getInstallments(firstSixDigits: Int, amount: Double) = viewModelScope.launch {
        installmentsResponse = Resource.Loading
        val result = mercadoPagoUseCase.getInstallments(firstSixDigits, amount).first()
        installmentsResponse = result
    }
}