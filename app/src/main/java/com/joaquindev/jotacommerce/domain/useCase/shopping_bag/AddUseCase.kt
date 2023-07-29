package com.joaquindev.jotacommerce.domain.useCase.shopping_bag

import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct
import com.joaquindev.jotacommerce.domain.repository.ShoppingBagRepository

class AddUseCase(private val repository: ShoppingBagRepository) {
   suspend operator fun invoke(shoppingBagProduct: ShoppingBagProduct) {
        repository.add(shoppingBagProduct)
    }
}