package com.joaquindev.jotacommerce.domain.useCase.catgeories

import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository

class GetCategoriesUseCase(private val repository: CategoriesRepository) {

     operator fun invoke() = repository.getCategories()
}