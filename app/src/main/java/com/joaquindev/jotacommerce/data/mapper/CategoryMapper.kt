package com.joaquindev.jotacommerce.data.mapper

import com.joaquindev.jotacommerce.data.dataSource.local.entity.CategoryEntity
import com.joaquindev.jotacommerce.domain.model.Category

fun CategoryEntity.toCategory(): Category {
    return Category(
        id = id, name = name, description = description, image = image
    )
}

fun Category.toCategoryEntity(): CategoryEntity{
    return CategoryEntity(
        id = id?:"",
        name=name,
        description = description,
        image = image ?:""

    )
}