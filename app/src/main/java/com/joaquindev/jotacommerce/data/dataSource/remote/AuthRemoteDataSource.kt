package com.joaquindev.jotacommerce.data.dataSource.remote

import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.model.User

import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email:String , password :String):Response<AuthResponse>

    suspend fun register(user: User):Response<AuthResponse>
}