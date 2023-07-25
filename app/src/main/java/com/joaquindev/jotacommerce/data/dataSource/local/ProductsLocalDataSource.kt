package com.joaquindev.jotacommerce.data.dataSource.local

import com.joaquindev.jotacommerce.data.dataSource.local.entity.CategoryEntity
import com.joaquindev.jotacommerce.data.dataSource.local.entity.ProductsEntity
import kotlinx.coroutines.flow.Flow

interface ProductsLocalDataSource {
    suspend fun insert(product:ProductsEntity)
    suspend fun insertAll(products:List<ProductsEntity>)
    fun findAll(): Flow<List<ProductsEntity>>
    fun findByCategory(idCategory:String): Flow<List<ProductsEntity>>
    suspend fun update(id:String , name:String , description:String ,image1:String,image2:String,price:Double)
    suspend fun delete(id:String )
}