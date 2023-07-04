package com.joaquindev.jotacommerce.domain.useCase.catgeories

import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoryUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke(category: Category, file: File)=repository.create(category,file)
}