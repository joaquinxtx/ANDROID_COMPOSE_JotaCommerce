package com.joaquindev.jotacommerce.domain.useCase.shopping_bag

import com.joaquindev.jotacommerce.domain.repository.ShoppingBagRepository

class FindByIdShoppingBagUseCase (private val repository: ShoppingBagRepository){

    suspend operator fun invoke(id:String) = repository.findById(id)
}