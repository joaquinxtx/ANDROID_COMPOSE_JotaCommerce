package com.joaquindev.jotacommerce.domain.useCase.shopping_bag

import com.joaquindev.jotacommerce.domain.repository.ShoppingBagRepository


class GetTotalUseCase(private val repository: ShoppingBagRepository) {
    suspend operator fun invoke()  = repository.getTotal()
}