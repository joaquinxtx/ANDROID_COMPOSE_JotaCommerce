package com.joaquindev.jotacommerce.domain.useCase.catgeories

import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository


class UpdateCategoryUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke(id:String,category: Category) = repository.update(id, category)
}