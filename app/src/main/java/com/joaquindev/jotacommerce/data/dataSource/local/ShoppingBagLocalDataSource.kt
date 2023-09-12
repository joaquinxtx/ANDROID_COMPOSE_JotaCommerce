package com.joaquindev.jotacommerce.data.dataSource.local


import com.joaquindev.jotacommerce.data.dataSource.local.entity.ShoppingBagProductEntity
import kotlinx.coroutines.flow.Flow

interface ShoppingBagLocalDataSource {
    suspend fun insert(product:ShoppingBagProductEntity)
    suspend fun insertAll(products:List<ShoppingBagProductEntity>)
    fun findAll(): Flow<List<ShoppingBagProductEntity>>
    fun findById(id:String): ShoppingBagProductEntity
    suspend fun update(id:String ,  quantity:Int)
    suspend fun delete(id:String )
    suspend fun getTotal(): Double
}