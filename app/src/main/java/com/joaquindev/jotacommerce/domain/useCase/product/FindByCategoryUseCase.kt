package com.joaquindev.jotacommerce.domain.useCase.product


import com.joaquindev.jotacommerce.domain.repository.ProductRepository


class FindByCategoryUseCase(private val repository: ProductRepository) {

    operator fun invoke(idCategory:String) =
        repository.findAllByCategory(idCategory )
}