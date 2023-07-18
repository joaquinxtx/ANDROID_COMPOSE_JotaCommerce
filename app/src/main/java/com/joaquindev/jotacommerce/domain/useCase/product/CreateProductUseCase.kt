package com.joaquindev.jotacommerce.domain.useCase.product

import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.repository.ProductRepository
import java.io.File

class CreateProductUseCase(private val repository: ProductRepository) {

    suspend operator fun invoke(product: Product, files: List<File>) =
        repository.create(product, files)
}