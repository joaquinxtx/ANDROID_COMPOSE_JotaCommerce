package com.joaquindev.jotacommerce.domain.useCase.mercado_pago

data class MercadoPagoUseCase(
    val getIdentificationType: GetIdentificationTypeUseCase,
    val getInstallments: GetInstallmentsUseCase
)
