package com.joaquindev.jotacommerce.domain.repository

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Category
import kotlinx.coroutines.flow.Flow
import java.io.File

interface CategoriesRepository {

    suspend fun  create(category: Category):Resource<Category>
     fun  getCategories(): Flow<Resource<List<Category>>>
    suspend fun  update(id:String , category: Category):Resource<Category>
    suspend fun  updateWithImage(id:String ,category: Category,file:File):Resource<Unit>
}