package com.joaquindev.jotacommerce.domain.useCase.product

import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.repository.ProductRepository


class UpdateProductUseCase(private val repository: ProductRepository) {

    suspend operator fun invoke(id:String , product: Product ) = repository.update(id,product)
}