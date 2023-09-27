package com.joaquindev.jotacommerce.domain.useCase.product


import com.joaquindev.jotacommerce.domain.repository.ProductRepository


class FindAllUseCase(private val repository: ProductRepository) {

     operator fun invoke() =
        repository.findAll()
}