package com.joaquindev.jotacommerce.data.repository

import android.util.Log
import com.joaquindev.jotacommerce.data.dataSource.local.CategoriesLocalDataSource
import com.joaquindev.jotacommerce.data.dataSource.local.entity.CategoryEntity
import com.joaquindev.jotacommerce.data.dataSource.remote.CategoriesRemoteDataSource
import com.joaquindev.jotacommerce.data.mapper.toCategory
import com.joaquindev.jotacommerce.data.mapper.toCategoryEntity
import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.Category
import com.joaquindev.jotacommerce.domain.repository.CategoriesRepository
import com.joaquindev.jotacommerce.domain.util.ResponseToRequest
import com.joaquindev.jotacommerce.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File

class CategoriesRepositoryImpl(
    private val remoteDataSource: CategoriesRemoteDataSource,
    private val localDataSource: CategoriesLocalDataSource
) :
    CategoriesRepository {
    override suspend fun create(category: Category, file: File): Resource<Category> {

        ResponseToRequest.send(remoteDataSource.create(category, file)).run {
            return when (this) {
                is Resource.Success -> {
                    localDataSource.create(this.data.toCategoryEntity())
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error Desconocido")
                }
            }
        }
    }

    override fun getCategories(): Flow<Resource<List<Category>>> = flow {
//        trySend(ResponseToRequest.send(remoteDataSource.getCategories()))
//        awaitClose {
//            cancel()
//        }

        localDataSource.getCategories().collect() {
            it.run {
//                if (this.isNotEmpty()) {
//                    Log.d("CategoriesRespositoryImpl", "dataloca: ${this}")
//                    emit(Resource.Success(this.map { categoryEntity -> categoryEntity.toCategory() }))
//                }
                val categoriesLocalMap =
                    this.map { categoryEntity -> categoryEntity.toCategory() }
                try {
                    ResponseToRequest.send(remoteDataSource.getCategories()).run {
                        when (this) {
                            is Resource.Success -> {
                                val categoriesRemote = this.data
                                if (!isListEqual(categoriesRemote, categoriesLocalMap)) {
                                    localDataSource.insertAll(categoriesRemote.map { category -> category.toCategoryEntity() })
                                }
                                emit(Resource.Success(categoriesRemote))
                            }
                            is Resource.Failure -> {
                                emit(Resource.Success(categoriesLocalMap))
                            }
                            else -> {
                                emit(Resource.Success(categoriesLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(categoriesLocalMap))
                }


            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun update(id: String, category: Category): Resource<Category> {
        ResponseToRequest.send(
            remoteDataSource.update(id, category)
        ).run {
            return when (this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error Desconocido")
                }
            }
        }
    }


    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, category, file)).run {
            return when (this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error Desconocido")
                }
            }
        }
    }


    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run {
            return when (this) {
                is Resource.Success -> {
                    localDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Error Desconocido")
                }
            }
        }
    }

    fun emitDataSource(categoriesLocal: List<CategoryEntity>) = flow {
        try {
            ResponseToRequest.send(remoteDataSource.getCategories()).run {
                when (this) {
                    is Resource.Success -> {
                        val categoriesRemote = this.data
                        val categoriesLocalMap =
                            categoriesLocal.map { categoryEntity -> categoryEntity.toCategory() }
                        localDataSource.insertAll(this.data.map { category -> category.toCategoryEntity() })
                        emit(Resource.Success(this.data))
                    }
                    else -> {}
                }
            }
        } catch (e: Exception) {

        }

    }
}