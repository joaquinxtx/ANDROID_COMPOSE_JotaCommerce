package com.joaquindev.jotacommerce.domain.useCase.shopping_bag

import com.joaquindev.jotacommerce.domain.model.ShoppingBagProduct
import com.joaquindev.jotacommerce.domain.repository.ShoppingBagRepository

class DeleteUseCase(private val repository: ShoppingBagRepository) {
   suspend operator fun invoke(id:String) {
        repository.delete(id)
    }
}