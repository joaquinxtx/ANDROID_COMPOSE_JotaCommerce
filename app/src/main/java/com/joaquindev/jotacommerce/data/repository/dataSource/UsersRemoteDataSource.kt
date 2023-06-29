package com.joaquindev.jotacommerce.data.repository.dataSource


import com.joaquindev.jotacommerce.domain.model.User

import retrofit2.Response
import java.io.File

interface UsersRemoteDataSource {

    suspend fun update(id:String ,user: User):Response<User>
    suspend fun updateWithImage(id:String ,user: User, file:File):Response<User>
}