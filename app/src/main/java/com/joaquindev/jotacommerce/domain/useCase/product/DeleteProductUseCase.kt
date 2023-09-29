package com.joaquindev.jotacommerce.domain.useCase.product


import com.joaquindev.jotacommerce.domain.repository.ProductRepository


class DeleteProductUseCase(private val repository: ProductRepository) {

    suspend operator fun invoke(id:String ) = repository.delete(id)
}