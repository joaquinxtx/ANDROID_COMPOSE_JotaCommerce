package com.joaquindev.jotacommerce.domain.useCase.catgeories

data class CategoriesUseCase(
    val createCategory: CreateCategoryUseCase,
    val getCategories: GetCategoriesUseCase,
    val updateCategory: UpdateCategoryUseCase,
    val updateCategoryWidthImage: UpdateCategoryWidthImageUseCase
)
