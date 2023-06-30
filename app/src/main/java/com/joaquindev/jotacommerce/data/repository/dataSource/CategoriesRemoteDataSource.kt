package com.joaquindev.jotacommerce.data.repository.dataSource

import com.joaquindev.jotacommerce.domain.model.Category
import retrofit2.Response
import java.io.File

interface CategoriesRemoteDataSource {

    suspend fun create(category: Category):Response<Category>
    suspend fun getCategories():Response<Category>
    suspend fun update(id:String ,category: Category):Response<Category>
    suspend fun updateWithImage(id:String ,category: Category, file:File):Response<Category>
    suspend fun delete(id:String ):Response<Unit>
}