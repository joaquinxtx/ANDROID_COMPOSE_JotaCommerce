package com.joaquindev.jotacommerce.domain.useCase.shopping_bag

import com.joaquindev.jotacommerce.domain.repository.ShoppingBagRepository

class FindAllShoppingBagUseCase (private val repository: ShoppingBagRepository){

    operator fun invoke()=repository.findAll()
}