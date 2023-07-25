package com.joaquindev.jotacommerce.data.mapper

import com.joaquindev.jotacommerce.data.dataSource.local.entity.ProductsEntity
import com.joaquindev.jotacommerce.domain.model.Product

fun ProductsEntity.toProduct():Product{
    return Product(
        id = id ,
        name= name,
        description=description,
        image1 = image1,
        image2 = image2,
        price = price,
        idCategory = idCategory,
        imageToUpdate = null
    )
}
fun Product.toProductsEntity():ProductsEntity{
    return ProductsEntity(
        id = id ?: "",
        name= name,
        description=description,
        image1 = image1 ?:"",
        image2 = image2?:"",
        price = price,
        idCategory = idCategory
    )
}