package com.joaquindev.jotacommerce.presentation.screens.client.payments.installments

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.*
import com.joaquindev.jotacommerce.domain.useCase.auth.AuthUseCase
import com.joaquindev.jotacommerce.domain.useCase.mercado_pago.MercadoPagoUseCase
import com.joaquindev.jotacommerce.domain.useCase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ClientPaymentsInstallmentsViewModel @Inject constructor(
    private val mercadoPagoUseCase: MercadoPagoUseCase,
    private val shoppingBagUseCase: ShoppingBagUseCase,
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var data = savedStateHandle.get<String>("payment_form")
    val cardTokenBody = CardTokenBody.fromJson(data!!)

    var cardTokenResponse by mutableStateOf<Resource<CardTokenResponse>?>(null)
        private set

    var paymentResponse by mutableStateOf<Resource<PaymentResponse>?>(null)
        private set

    var installmentsResponse by mutableStateOf<Resource<Installment>?>(null)
        private set

    var installment by mutableStateOf<Installment?>(null)
        private set

    var totalToPay by mutableStateOf(0.0)
        private set

    var user by mutableStateOf<User?>(null)
        private set

    var shoppingBag = mutableStateListOf<ShoppingBagProduct>()
        private set

    var selectedInstallment by mutableStateOf<PayerCost?>(null)

    init {
        getTotalToPay()
        getSessionData()
        getShoppingBag()
    }

    fun getShoppingBag() = viewModelScope.launch {
        shoppingBag.addAll(shoppingBagUseCase.findAll().first())
    }

    fun getSessionData() = viewModelScope.launch {
        user = authUseCase.getSessionData().first().user
    }

    fun getTotalToPay() = viewModelScope.launch {
        totalToPay = shoppingBagUseCase.getTotal()
    }

    fun getInstallments(firstSixDigits: Int, amount: Double) = viewModelScope.launch {
        installmentsResponse = Resource.Loading
        val result = mercadoPagoUseCase.getInstallments(firstSixDigits, amount).first()
        installmentsResponse = result
        installmentsResponse.run {
            when(this) {
                is Resource.Success -> {
                    installment = this.data
                }
                else -> {}
            }
        }
        Log.d("ClientPaymentsFormViewModel", "Data: ${installmentsResponse}")
    }

    fun createCardToken() = viewModelScope.launch {
        cardTokenResponse = Resource.Loading
        val result = mercadoPagoUseCase.createCardToken(cardTokenBody)
        cardTokenResponse = result
        Log.d("ClientPaymentsInstallmentsViewModel", "Card Token Body: ${cardTokenBody}")
        Log.d("ClientPaymentsInstallmentsViewModel", "Card Token Response: ${cardTokenResponse}")
    }

    fun createPayment(token: String) = viewModelScope.launch {
        val paymentBody = PaymentBody(
            token = token,
            installments = selectedInstallment?.installments!!,
            issuerID = installment?.issuer?.id!!,
            paymentMethodID = installment?.paymentMethodID!!,
            transactionAmount = totalToPay,
            payer = Payer(
                email = user?.email ?: "",
                identification = Identification(
                    type = cardTokenBody.cardholder.identification.type,
                    number = cardTokenBody.cardholder.identification.number
                )
            ),
            order = Order(
                idClient = user?.id ?: "",
                idAddress = user?.address?.id ?: "",
                products = shoppingBag.toList()
            )
        )
        Log.d("ClientPaymentsInstallmentsViewModel", "Payment Body: ${paymentBody}")
        paymentResponse = Resource.Loading
        val result = mercadoPagoUseCase.createPayment(paymentBody)
        paymentResponse = result
        Log.d("ClientPaymentsInstallmentsViewModel", "payment Response: ${paymentResponse}")
    }

}