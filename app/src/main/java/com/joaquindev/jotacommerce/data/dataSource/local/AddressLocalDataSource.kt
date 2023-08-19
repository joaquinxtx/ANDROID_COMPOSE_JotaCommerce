package com.joaquindev.jotacommerce.data.dataSource.local

import com.joaquindev.jotacommerce.data.dataSource.local.entity.AddressEntity

import kotlinx.coroutines.flow.Flow

interface AddressLocalDataSource {
    suspend fun insert(address:AddressEntity)
    suspend fun insertAll(address:List<AddressEntity>)
    fun findByUser(idUser:String): Flow<List<AddressEntity>>
    suspend fun update(id:String , address:String,neighborhood:String)
    suspend fun delete(id:String )
}