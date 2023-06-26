package com.joaquindev.jotacommerce.domain.repository

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.User

interface UserRepository {

    suspend fun update(id:String ,user: User): Resource<User>
}