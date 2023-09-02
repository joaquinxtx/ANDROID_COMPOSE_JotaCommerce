package com.joaquindev.jotacommerce.domain.useCase.mercado_pago

import com.joaquindev.jotacommerce.domain.repository.MercadoPagoRepository

class GetInstallmentsUseCase(private val repository: MercadoPagoRepository) {
    operator fun invoke( firstSixDigits:Int,amount:Double ) = repository.getInstallments(firstSixDigits, amount)
}