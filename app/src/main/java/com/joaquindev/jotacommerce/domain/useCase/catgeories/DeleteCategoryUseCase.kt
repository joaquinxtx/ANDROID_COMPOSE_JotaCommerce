package com.joaquindev.jotacommerce.domain.useCase.catgeories

import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository
import java.io.File

class DeleteCategoryUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke(id:String)=repository.delete(id)
}