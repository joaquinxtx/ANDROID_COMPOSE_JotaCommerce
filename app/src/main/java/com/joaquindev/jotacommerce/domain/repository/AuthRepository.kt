package com.joaquindev.jotacommerce.domain.repository

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.AuthResponse
import com.joaquindev.jotacommerce.domain.model.User

interface AuthRepository {

    suspend fun login(email:String , password:String): Resource<AuthResponse>

    suspend fun  register(user:User):Resource<AuthResponse>

}