package com.joaquindev.jotacommerce.domain.useCase.mercado_pago

import com.joaquindev.jotacommerce.domain.model.PaymentBody
import com.joaquindev.jotacommerce.domain.repository.MercadoPagoRepository


class CreatePaymentUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(paymentBody: PaymentBody) = repository.createPayment(paymentBody)

}