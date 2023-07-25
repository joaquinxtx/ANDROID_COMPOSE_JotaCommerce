package com.joaquindev.jotacommerce.domain.useCase.product

data class ProductUseCase(
    val createProduct: CreateProductUseCase,
    val findByCategory: FindByCategoryUseCase,
    val updateProduct: UpdateProductUseCase,
    val updateProductWithImage: UpdateProductWithImageUseCase,
    val deleteProduct: DeleteProductUseCase,
    val findAll: FindAllUseCase
)
