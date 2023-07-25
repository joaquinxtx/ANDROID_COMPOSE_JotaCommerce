package com.joaquindev.jotacommerce.domain.useCase.product

import com.joaquindev.jotacommerce.domain.model.Product
import com.joaquindev.jotacommerce.domain.repository.ProductRepository
import java.io.File

class FindAllUseCase(private val repository: ProductRepository) {

    suspend operator fun invoke() =
        repository.findAll()
}