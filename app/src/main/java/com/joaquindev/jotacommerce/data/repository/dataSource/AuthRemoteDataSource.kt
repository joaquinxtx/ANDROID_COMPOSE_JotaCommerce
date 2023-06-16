package com.joaquindev.jotacommerce.data.repository.dataSource

import com.joaquindev.jotacommerce.domain.model.AuthResponse

import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email:String , password :String):Response<AuthResponse>
}