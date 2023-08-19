package com.joaquindev.jotacommerce.domain.useCase.address

data class AddressUseCase(
    val createAddress:CreateAddressUseCase,
    val findByUserAddress:FindByUserAddressUseCase
)
