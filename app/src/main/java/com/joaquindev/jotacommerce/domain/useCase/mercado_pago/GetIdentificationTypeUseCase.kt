package com.joaquindev.jotacommerce.domain.useCase.mercado_pago

import com.joaquindev.jotacommerce.domain.repository.MercadoPagoRepository

class GetIdentificationTypeUseCase(private val repository: MercadoPagoRepository) {
    operator fun invoke( ) = repository.getIdentificationTypes()
}