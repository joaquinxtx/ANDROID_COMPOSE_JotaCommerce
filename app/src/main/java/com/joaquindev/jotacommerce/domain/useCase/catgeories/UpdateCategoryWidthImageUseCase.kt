package com.joaquindev.jotacommerce.domain.useCase.catgeories

import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository
import java.io.File

class UpdateCategoryWidthImageUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke(id: String, category: Category, file: File) =
        repository.updateWithImage(id, category, file)
}