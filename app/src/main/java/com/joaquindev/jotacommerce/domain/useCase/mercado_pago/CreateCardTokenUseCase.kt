package com.joaquindev.jotacommerce.domain.useCase.mercado_pago

import com.joaquindev.jotacommerce.domain.model.CardTokenBody
import com.joaquindev.jotacommerce.domain.repository.MercadoPagoRepository


class CreateCardTokenUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(cardTokenBody: CardTokenBody) = repository.createCardToken(cardTokenBody)

}