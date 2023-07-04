package com.joaquindev.jotacommerce.data.repository

import com.joaquindev.jotacommerce.data.repository.dataSource.CategoriesRemoteDataSource
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import java.io.File

class CategoriesRepositoryImpl(private val categoriesRemoteDataSource: CategoriesRemoteDataSource) :
    CategoriesRepository {
    override suspend fun create(category: Category,file:File): Resource<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.create(category,file)
    )

    override fun getCategories(): Flow<Resource<List<Category>>> {
        TODO("Not yet implemented")
    }

    override suspend fun update(id: String, category: Category): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Unit> {
        TODO("Not yet implemented")
    }
}