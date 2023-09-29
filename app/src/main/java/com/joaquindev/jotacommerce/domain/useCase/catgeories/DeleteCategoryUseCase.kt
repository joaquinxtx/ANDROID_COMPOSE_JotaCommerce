package com.joaquindev.jotacommerce.domain.useCase.catgeories


import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository


class DeleteCategoryUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke(id:String)=repository.delete(id)
}