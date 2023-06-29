package com.joaquindev.jotacommerce.domain.repository

import com.joaquindev.jotacommerce.domain.Resource
import com.joaquindev.jotacommerce.domain.model.User
import java.io.File

interface UserRepository {

    suspend fun update(id:String ,user: User): Resource<User>
    suspend fun updateWithImage(id:String ,user: User, file:File): Resource<User>
}